/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.banking.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sheridan.banking.business.Account;
import sheridan.banking.business.Chequing;
import sheridan.banking.business.Customer;
import sheridan.banking.business.Savings;
import sheridan.banking.business.Transaction;

/**
 *
 * @author reliq
 */
public class CustomerController {

    public static String login(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String view = "redirect:";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");

            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUsername(user);
                customer.setUser_id(rs.getInt("user_id"));
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                view = "CustomerView";
            }

            //load the account information to the session
        } catch (Exception e) {

        }
        return view;
    }

    public static void loadAccount(HttpServletRequest request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from customer_accounts where user_id=?");

            HttpSession session = request.getSession();

            Customer customer = (Customer) session.getAttribute("customer");
            int userID = customer.getUser_id();
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setAccount_id(rs.getInt("account_id"));
                account.setUser_id(rs.getInt("user_id"));
                account.setCheq_id(rs.getInt("cheq_id"));
                account.setSaving_id(rs.getInt("saving_id"));
                session.setAttribute("account", account);

            }
            PreparedStatement ps2 = con.prepareStatement("select * from chequing_acc_table where user_id=?");
            PreparedStatement ps3 = con.prepareStatement("select * from savings_acc_table where user_id=?");
            ps2.setInt(1, userID);
            ps3.setInt(1, userID);
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            while (rs2.next()) {
                Chequing chequing = new Chequing();
                chequing.setAccount_id(rs2.getInt("account_id"));
                chequing.setUser_id(rs2.getInt("user_id"));
                chequing.setCheq_id(rs2.getInt("cheq_id"));
                chequing.setBalance(rs2.getInt("balance"));
                session.setAttribute("chequing_acc", chequing);

            }
            while (rs3.next()) {
                Savings savings = new Savings();
                savings.setAccount_id(rs3.getInt("account_id"));
                savings.setUser_id(rs3.getInt("user_id"));
                savings.setSaving_id(rs3.getInt("saving_id"));
                savings.setBalance(rs3.getInt("balance"));
                session.setAttribute("savings_acc", savings);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String viewSummary(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            return "expired"; // show "your session has expired" with "expired.jsp"
        } else {
            view = "viewSummary";

        }
        return view;
    }

    public static String viewTransactions(HttpServletRequest request) {
        String view = "redirect:";
        //display any transactions that is relative to the account id
        //check which account was used in terms of that transaction
        //then display the information of that transaction
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from transactions where account_id=?");
            int account_id = account.getAccount_id();
            ps.setInt(1, account_id);
            ResultSet rs = ps.executeQuery();

            Chequing chequing = (Chequing) session.getAttribute("chequing_acc");
            Savings savings = (Savings) session.getAttribute("savings_acc");
            //creating the transaction class with balances from the accounts
//            Transaction transaction = new Transaction();
//            transaction.setCheq_balance(chequing.getBalance());
//            transaction.setSavings_balance(savings.getBalance());
            double ChequingBalance = chequing.getBalance();
            double SavingsBalance = savings.getBalance();
            //transaction array
            ArrayList<Transaction> transactionList = new ArrayList<>();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransac_id(rs.getInt("transact_id"));
                //transaction.setAccount_id(rs.getInt("account_id"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setDesc(rs.getString("desc"));
                transaction.setType(rs.getString("type"));
                transaction.setAccount_type(rs.getString("account_type"));
                if (transaction.getAccount_type().equals("Chequing") && transaction.getType().contains("W")) {
                    ChequingBalance = ChequingBalance - transaction.getAmount();
                    transaction.setCheq_balance(ChequingBalance);
                    transaction.setSavings_balance(SavingsBalance);
                } else if (transaction.getAccount_type().equals("Chequing") && transaction.getType().contains("D")) {
                    ChequingBalance = ChequingBalance + transaction.getAmount();
                    transaction.setCheq_balance(ChequingBalance);
                    transaction.setSavings_balance(SavingsBalance);

                } else if (transaction.getAccount_type().equals("Savings") && transaction.getType().contains("W")) {
                    SavingsBalance = SavingsBalance - transaction.getAmount();
                    transaction.setSavings_balance(SavingsBalance);
                    transaction.setCheq_balance(ChequingBalance);

                } else if (transaction.getAccount_type().equals("Savings") && transaction.getType().contains("D")) {
                    SavingsBalance = SavingsBalance + transaction.getAmount();
                    transaction.setSavings_balance(SavingsBalance);
                    transaction.setCheq_balance(ChequingBalance);
                }
                //add transaction to an array list
                transactionList.add(transaction);
                session.setAttribute("transactList", transactionList);
                view = "viewTransac";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public static String viewTransfer(HttpServletRequest request) {
        String view = "redirect:";
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            return "expired"; // show "your session has expired" with "expired.jsp"
        } else {
            view = "viewTransfer";
        }
         return view ;
    }
   
public static String confirmTransfer(HttpServletRequest request) {
        String view = "redirect:";
        HttpSession session = request.getSession();
        int accountNoTransfer = Integer.parseInt(request.getParameter("accountNo"));
        double amountTransfer = Double.parseDouble(request.getParameter("amount"));
        String accountType = request.getParameter("account_type");
        System.out.println(accountType);
        view = "viewTransfer";
        return view;
    }
public static String makeTransfer(HttpServletRequest request) {
        String view = "redirect:";
        HttpSession session = request.getSession();
        int accountNoTransfer = Integer.parseInt(request.getParameter("accountNo"));
        double amountTransfer = Double.parseDouble(request.getParameter("amount"));
        String accountType = request.getParameter("account_type");
        System.out.println(accountType);
        view = "viewTransfer";
        return view;
    }

    public static String viewBalance(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            return "expired"; // show "your session has expired" with "expired.jsp"
        } else {
            view = "viewBalance";
            return view;
        }
    }
}

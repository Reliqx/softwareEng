/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.banking.controller;

import sheridan.banking.business.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                customer.setRole(rs.getString("role"));
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                if (customer.getRole().equals("Administrator")) {
                    view = "adminView";
                } else {
                    view = "CustomerView";
                }
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
        return view;
    }

    public static String confirmTransfer(HttpServletRequest request) {
        String view = "redirect:";
        HttpSession session = request.getSession();
        int accountNoTransfer = Integer.parseInt(request.getParameter("accountNo"));
        double amountTransfer = Double.parseDouble(request.getParameter("amount"));
        String accountTarget = request.getParameter("accountTarget");
        String accountType = request.getParameter("account_type");
        if (accountType.contains(" ")) {
            accountType = accountType.substring(0, accountType.indexOf(" "));
        }
        //make transfer class
        Transfer transfer = new Transfer();
        transfer.setAccountNoTransfer(accountNoTransfer);
        transfer.setAccountType(accountType);
        transfer.setAmountTransferred(amountTransfer);
        transfer.setAccountTarget(accountTarget);
        session.setAttribute("transfer", transfer);
        view = "confirmTransfer";
        return view;
    }
//sql statements here

    public static String makeTransfer(HttpServletRequest request) {
        String view = "redirect:";
        HttpSession session = request.getSession();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            Transfer transfer = (Transfer) session.getAttribute("transfer");
            PreparedStatement ps = con.prepareStatement("select * from chequing_acc_table where account_id=?");
            PreparedStatement ps2 = con.prepareStatement("select * from savings_acc_table where account_id=?");
            //gets the information of the account we're transferring
            ps.setInt(1, transfer.getAccountNoTransfer());
            ps2.setInt(1, transfer.getAccountNoTransfer());
            //need to create error handling if target account does not exists in the table
            //need to create error handling if current account does not have enough amount
            
            //if the target is chequing 
            if (transfer.getAccountTarget().contains("Chequing")) {
                ResultSet rs = ps.executeQuery();
                Chequing transferAccount = new Chequing();
                //System.out.println("test");
                while (rs.next()) {
                    transferAccount.setAccount_id(rs.getInt("account_id"));
                    transferAccount.setUser_id(rs.getInt("user_id"));
                    transferAccount.setCheq_id(rs.getInt("cheq_id"));
                    transferAccount.setBalance(rs.getInt("balance"));
                    
                    request.setAttribute("transferAccount", transferAccount);
                    //view = "transferComplete";
                }
            
                //add the transfer amount to the transfer account
                
               transferAccount.transferAmount(transfer.getAmountTransferred());
//                //update db
                PreparedStatement ps3 = con.prepareStatement("UPDATE chequing_acc_table SET balance=? where account_id=?");
                ps3.setDouble(1,transferAccount.getBalance());
                ps3.setInt(2, transferAccount.getAccount_id());
                ps3.executeQuery();
//                
                view = "transferComplete";
                
            } 
 //           else if (transfer.getAccountType().equals("Savings")) {
//                ResultSet rs2 = ps2.executeQuery();
//                while (rs2.next()) {
//                    Savings transferAccount = new Savings();
//                    transferAccount.setAccount_id(rs2.getInt("account_id"));
//                    transferAccount.setUser_id(rs2.getInt("user_id"));
//                    transferAccount.setCheq_id(rs2.getInt("cheq_id"));
//                    transferAccount.setBalance(rs2.getInt("balance"));
//                    session.setAttribute("transfer_acc", transferAccount);
//                }
//                view = "transferComplete";
//            }
        } catch (Exception e) {
            e.printStackTrace();
            {

            }


        }
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
        public static String createAccount(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";
        Random r = new Random();
        int Low = 100000000;
        int High = 999999999;
        int newUserID = r.nextInt(High - Low) + Low;
        int accountID = r.nextInt(High - Low) + Low;
        int chequingID = r.nextInt(High - Low) + Low;
        int savingsID = r.nextInt(High - Low) + Low;

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;

        //Check for existing user
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            ps = con.prepareStatement("select * from users;");
            ps2 = con.prepareStatement("select * from customer_accounts;");
            ps3 = con.prepareStatement("select * from chequing_acc_table;");
            ps4 = con.prepareStatement("select * from savings_acc_table;");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            HttpSession session = request.getSession();
            if (session == null || session.getAttribute("customer") == null) {
                return "expired"; // show "your session has expired" with "expired.jsp"
            } else {
                //Checking User table
                Customer customer = (Customer) session.getAttribute("customer");
                ResultSet rs = ps.executeQuery();

                Account accountCheck = new Account();
                Chequing chequingCheck = new Chequing();
                Savings savingsCheck = new Savings();
                Customer customerCheck = new Customer();

                while (rs.next()) {

                    customerCheck.setUser_id(rs.getInt("user_id"));
                    customerCheck.setUsername(rs.getString("username"));

                    //Keep randoming unitl a valid number is found
                    while (customerCheck.getUser_id() == newUserID) {
                        newUserID = r.nextInt(High - Low) + Low;
                    }
                }

                ps.clearParameters();
                ps = con.prepareStatement("INSERT INTO users (user_id, username, password, role) VALUES (?,?,?,?)");

                //Checking customer_accounts table
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {

                    accountCheck.setAccount_id(rs2.getInt("account_id"));

                    //Keep randoming unitl a valid number is found
                    while (accountCheck.getUser_id() == accountID) {
                        accountID = r.nextInt(High - Low) + Low;
                    }
                }
                ps2.clearParameters();
                ps2 = con.prepareStatement("INSERT INTO customer_accounts (account_id, user_id, cheq_id, saving_id) VALUES (?,?,?,?)");

                //Checking chequing table
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {

                    chequingCheck.setCheq_id(rs3.getInt("cheq_id"));

                    //Keep randoming unitl a valid number is found
                    while (chequingCheck.getCheq_id() == chequingID) {
                        chequingID = r.nextInt(High - Low) + Low;
                    }
                }

                ps3.clearParameters();
                ps3 = con.prepareStatement("INSERT INTO chequing_acc_table (cheq_id, account_id, user_id, balance) VALUES (?,?,?,?)");

                //Checking savings table
                ResultSet rs4 = ps4.executeQuery();
                while (rs4.next()) {

                    savingsCheck.setSaving_id(rs4.getInt("saving_id"));

                    //Keep randoming unitl a valid number is found
                    while (savingsCheck.getUser_id() == savingsID) {
                        savingsID = r.nextInt(High - Low) + Low;
                    }
                }
                ps4.clearParameters();
                ps4 = con.prepareStatement("INSERT INTO savings_acc_table (saving_id, account_id, user_id, balance) VALUES (?,?,?,?)");

                if (newUserID == accountID) {
                }
                //User
                ps.setInt(1, newUserID);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, role);

                //Account
                ps2.setInt(1, accountID);
                ps2.setInt(2, newUserID);
                ps2.setInt(3, chequingID);
                ps2.setInt(4, savingsID);

                //Chequing
                ps3.setInt(1, chequingID);
                ps3.setInt(2, accountID);
                ps3.setInt(3, newUserID);
                ps3.setInt(4, 100);

                //Savings
                ps4.setInt(1, savingsID);
                ps4.setInt(2, accountID);
                ps4.setInt(3, newUserID);
                ps4.setInt(4, 100);

                ps.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();
                ps4.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        view = "createAccount";

        return view;
    }

    public static String viewAccounts(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";

        try {

            List<Customer> list = Customer.getAll();

            for (int x = 0; x < list.size(); x++) {
                System.out.println(list.get(x));
            }
            request.setAttribute("visits", list);

            view = "viewAccounts";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    public static String remove(HttpServletRequest request) {
        String view = "redirect:";
        try {
            Customer.delete(request.getParameter("user_id"));
            view = "viewAccounts";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return view;
    }
}


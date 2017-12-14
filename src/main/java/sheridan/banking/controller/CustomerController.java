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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sheridan.banking.business.Account;
import sheridan.banking.business.Chequing;
import sheridan.banking.business.Customer;
import sheridan.banking.business.Savings;

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
            rs.close();
            con.close();
            ps.close();
        } catch (Exception e) {

        }
        return view;
    }

    public static String viewSummary(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from customer_accounts where user_id=?");

            HttpSession session = request.getSession();
            if (session == null || session.getAttribute("customer") == null) {
                return "expired"; // show "your session has expired" with "expired.jsp"
            } else {
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

                view = "viewSummary";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;

    }

    public static String viewBalance(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String view = "redirect:";
        HttpSession session = request.getSession();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from chequing_acc_table where user_id=?");
            PreparedStatement ps2 = con.prepareStatement("select * from savings_acc_table where user_id=?");
            if (session == null || session.getAttribute("customer") == null) {
                return "expired"; // show "your session has expired" with "expired.jsp"
            } else {
                Customer customer = (Customer) session.getAttribute("customer");
                Account account = (Account) session.getAttribute("account");
                int userID = customer.getUser_id();
                ps.setInt(1, userID);
                ps2.setInt(1, userID);
                ResultSet rs = ps.executeQuery();
                ResultSet rs2 = ps2.executeQuery();
                while (rs.next()) {
                    Chequing chequing = new Chequing();
                    chequing.setAccount_id(rs.getInt("account_id"));
                    chequing.setUser_id(rs.getInt("user_id"));
                    chequing.setCheq_id(rs.getInt("cheq_id"));
                    chequing.setBalance(rs.getInt("balance"));
                    session.setAttribute("chequing_acc", chequing);

                }
                while (rs2.next()) {
                    Savings savings = new Savings();
                    savings.setAccount_id(rs2.getInt("account_id"));
                    savings.setUser_id(rs2.getInt("user_id"));
                    savings.setSaving_id(rs2.getInt("saving_id"));
                    savings.setBalance(rs2.getInt("balance"));
                    session.setAttribute("savings_acc", savings);

                }
                view = "viewBalance";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}

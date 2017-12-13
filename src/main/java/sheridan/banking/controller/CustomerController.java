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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * chequing_acc_table where user_id=?");
            //PreparedStatement ps2 = con.prepareStatement("select * savings_acc_table where user_id=?");
            
             HttpSession session = request.getSession();
            if (session == null || session.getAttribute("customer") == null) {
                return "expired"; // show "your session has expired" with "expired.jsp"
            } else {
                Customer customer = (Customer) session.getAttribute("customer");
                int userID = customer.getUser_id();
                ps.setInt(1, userID);
                //ps2.setInt(1, userID);
                ResultSet rs = ps.executeQuery();
                //ResultSet rs2 = ps2.executeQuery();
                
                while(rs.next()){
                    Chequing chequing =  new Chequing();
                    chequing.setAccount_id(rs.getInt("account_id"));
                    chequing.setUser_id(rs.getInt("user_id"));
                    chequing.setCheq_id(rs.getInt("cheq_id"));
                    chequing.setSaving_id(rs.getInt("saving_id"));
                    chequing.setBalance(rs.getDouble("balance"));
                    session.setAttribute("chequing_acc", chequing);
                    
                }
//                 while(rs2.next()){
//                    Savings saving =  new Savings();
//                    saving.setAccount_id(rs2.getInt("account_id"));
//                    saving.setUser_id(rs2.getInt("user_id"));
//                    saving.setCheq_id(rs2.getInt("cheq_id"));
//                    saving.setSaving_id(rs2.getInt("saving_id"));
//                    saving.setBalance(rs2.getDouble("balance"));
//                    session.setAttribute("saving_acc", saving);
//                }
                 view = "viewBalance";
            }
        }catch (Exception e) {
            e.printStackTrace();
    }
        
        return view;
}
    }


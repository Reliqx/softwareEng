/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.banking.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reliq
 */
public class Customer {
    private String username;
    private String role;
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
     public static List<Customer> getAll() {

        Statement st = null;
        ResultSet rs = null;

        ArrayList<Customer> customers = new ArrayList<>();

        String q = "SELECT * FROM users";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");
            st = con.createStatement();
            rs = st.executeQuery(q);

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setUser_id(rs.getInt("user_id"));
                customer.setUsername(rs.getString("username"));
                customer.setRole(rs.getString("role"));
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }

    public static String delete(String userID) {

        PreparedStatement ps1 = null;

        String update1 = "DELETE FROM savings_acc_table WHERE user_id = ?";
        String update2 = "DELETE FROM chequing_acc_table WHERE user_id = ?";
        String update3 = "DELETE FROM customer_accounts WHERE user_id = ?";
        String update4 = "DELETE FROM users WHERE user_id = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheridanbank?", "root", "root");

            ps1 = con.prepareStatement(update1);
            ps1.setString(1, userID);
            ps1.executeUpdate();

            ps1.clearParameters();
            ps1 = con.prepareStatement(update2);
            ps1.setString(1, userID);
            ps1.executeUpdate();

            ps1.clearParameters();
            ps1 = con.prepareStatement(update3);
            ps1.setString(1, userID);
            ps1.executeUpdate();

            ps1.clearParameters();
            ps1 = con.prepareStatement(update4);
            ps1.setString(1, userID);
            ps1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:viewAccounts.do";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.banking.business;

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

    public void setUser_id(int account_id) {
        this.user_id = account_id;
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
}

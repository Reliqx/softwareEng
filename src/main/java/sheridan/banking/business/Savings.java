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
public class Savings extends Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void transferAmount(double amount){
        balance = this.balance + amount;
    }
    public void withdrawAmount(double amount){
        balance = this.balance - amount;
    }    
}

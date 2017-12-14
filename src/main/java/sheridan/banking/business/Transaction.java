/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.banking.business;

/**
 *
 * @author Alvin Pascua
 */
public class Transaction {

    private int transac_id;
    private double amount;
    private String desc;
    private int account_id;
    private String account_type;
    private String type;
    private double cheq_balance;
    private double savings_balance;

    public double getCheq_balance() {
        return cheq_balance;
    }

    public void setCheq_balance(double cheq_balance) {
        this.cheq_balance = cheq_balance;
    }

    public double getSavings_balance() {
        return savings_balance;
    }

    public void setSavings_balance(double savings_balance) {
        this.savings_balance = savings_balance;
    }

    public double cheqWithdrawAmount(Double amount) {
        return cheq_balance - amount;
    }

    public double cheqDepositAmount(Double amount) {
        return cheq_balance +amount;
    }

    public double savingsWithdrawAmount(Double amount) {
        return savings_balance - amount;
    }

    public double savingsDepositAmount(Double balance) {
        return savings_balance + amount;
    }

    public int getTransac_id() {
        return transac_id;
    }

    public void setTransac_id(int transac_id) {
        this.transac_id = transac_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

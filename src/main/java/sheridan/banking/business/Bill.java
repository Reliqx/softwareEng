package sheridan.banking.business;

/**
 *
 * @author Colin
 */
public class Bill {

    public int bilID = 0;
    public int accountID = 0;
    public double amount = 0;
    public String paid = "";

    public Bill() {
    }

    public int getBilID() {
        return bilID;
    }

    public void setBilID(int bilID) {
        this.bilID = bilID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }


}
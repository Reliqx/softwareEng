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
public class Account {
    public int account_id;
    public int user_id;
    public int cheq_id;
    public int saving_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCheq_id() {
        return cheq_id;
    }

    public void setCheq_id(int cheq_id) {
        this.cheq_id = cheq_id;
    }

    public int getSaving_id() {
        return saving_id;
    }

    public void setSaving_id(int saving_id) {
        this.saving_id = saving_id;
    }
}

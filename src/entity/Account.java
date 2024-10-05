
package entity;

import java.io.Serializable;

/**
 *
 * @author ABDUL MOIZ
 */
public class Account implements Serializable{
    private String accountNO;
    private String Name;
    private String type;
    private  double  balance;

    public Account() {
    }

    public Account(String accountNO, String Name, String type, double balance) {
        this.accountNO = accountNO;
        this.Name = Name;
        this.type = type;
        this.balance = balance;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}

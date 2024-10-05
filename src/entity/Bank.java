
package entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABDUL MOIZ
 */

public class Bank {

    public static ArrayList<Account> acounts;
static File file=new File("Data.txt");
    static {
        acounts = new ArrayList();
    }

    public static ArrayList<Account> getAcounts() {
        return acounts;
    }

    public static void setAcounts(ArrayList<Account> acounts) {
        Bank.acounts = acounts;
    }
    
public static void storedata(){
           
            
     if(!file.exists()){ 
               try {
               file.createNewFile();
               } 
               catch (IOException ex) {
                   ex.getStackTrace();
               }
}

ObjectOutputStream data =null;
         try {
            
            data=new ObjectOutputStream(new FileOutputStream(file));
            data.reset();
            data.writeObject(Bank.acounts);
            data.flush();
            data.close();
        } catch (FileNotFoundException ex) {
  ex.getStackTrace();
        } catch (IOException ex) {
        ex.getStackTrace();
        }
     
    
}
public static void getData(){
    ObjectInputStream input=null;
        try {
            input=new ObjectInputStream(new FileInputStream(file));
           Bank.acounts = (ArrayList<Account>) input.readObject();
           
            
        } catch (FileNotFoundException ex) {
        ex.getStackTrace();
        } catch (IOException ex) {
         
        ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.getStackTrace();
        }
}
    public static void deposit(String accountNo, Double Balance) {
        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (Bank.acounts.get(i).getAccountNO().equals(accountNo)) {
                Bank.acounts.get(i).setBalance(Bank.acounts.get(i).getBalance() + Balance);
                error(Balance+" Added Sucssfully"+ "  Now Your Current Balance is"+Bank.acounts.get(i).getBalance());
            }
        }
        }
    

    public static void withdraw(String accountNo, Double Balance) {
        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (Bank.acounts.get(i).getAccountNO().equals(accountNo)) {
                if(Bank.acounts.get(i).getBalance()>Balance){
                Bank.acounts.get(i).setBalance(Bank.acounts.get(i).getBalance() - Balance);
                error(Balance+" Withdraw Sucssfully"+ "  Now Your Current Balance is"+Bank.acounts.get(i).getBalance());
            }
                else{
                    error(Bank.acounts.get(i).getBalance()+"is less then"+Balance);
                }
            }
            
        }
    }
    public static boolean checkacount(String accountNo){
        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (Bank.acounts.get(i).getAccountNO().equals(accountNo)) {
                return true;
            }
            
        }
        return false;
    }

    public static void transfer(String accountNo, String transfer, Double Balance) {
        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (Bank.acounts.get(i).getAccountNO().equals(accountNo)) {
                for (int j = 0; j < Bank.acounts.size(); j++) {
                    if (Bank.acounts.get(j).getAccountNO().equals(transfer)) {
                        if(Bank.acounts.get(i).getBalance()>Balance){
                        Bank.acounts.get(i).setBalance(Bank.acounts.get(i).getBalance() - Balance);
                        Bank.acounts.get(j).setBalance(Bank.acounts.get(j).getBalance()+Balance);
                        error("Your Balance is transfer sucesfully in"+transfer);
                    }
                        else{
                            error(Bank.acounts.get(i).getBalance()+"is less then"+Balance);
                        }
                    }
                }
            }
        }
    }

    public static boolean check(Account p1) {
        if (acounts != null) {
            for (int i = 0; i < Bank.acounts.size(); i++) {
                if (Bank.acounts.get(i).getAccountNO().equals(p1.getAccountNO())) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void DeleteAcount(Account obj) {

        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (obj.getAccountNO().equals(Bank.acounts.get(i).getAccountNO())) {
                Bank.acounts.remove(i);
                error("Acount Delete Succesfullty");
            }
        }
    }

    public static void editAccount(Account obj) {

        for (int i = 0; i < Bank.acounts.size(); i++) {
            if (obj.getAccountNO().equals(Bank.acounts.get(i).getAccountNO())) {
                Bank.acounts.get(i).setName(obj.getName());
                Bank.acounts.get(i).setType(obj.getType());
                Bank.acounts.get(i).setBalance(obj.getBalance());
                error("Acount Edit Succesfullty");
                return;
            }

        }

        error("Acount not Found");

    }

    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}

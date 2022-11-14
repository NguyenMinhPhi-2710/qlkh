package qlkh;
import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    protected String accountName;
    protected String password;
    protected String staffID;
    protected String roleID;

    public Account(){
        accountName= null;
        password=null;
        staffID=null;
        roleID=null;
    }
    public Account(String accountName, String password,String staffID){
        this.accountName = accountName;
        this.password = password;
        this.staffID = staffID;
    }
    public Account(Account account){
        this.accountName = account.accountName;
        this.password = account.password;
        this.staffID = account.staffID;
    }
    public Account(String accountName, String password){
        this.accountName = accountName;
        this.password = password;
    }
    public String getAccountName(){
        return accountName;
    }
    public void setAccountName(){
        accountName = sc.nextLine();
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(){
        password = sc.nextLine();
    }
    public String getStaffID(){
        return staffID;
    }
    public void setStaffID(){
        staffID = sc.nextLine();
    }
    public void input(){
        setAccountName();
        setPassword();
        setStaffID();
    }
    public String toString(){
        return accountName +" " +password +" " +staffID +" " +roleID; 
    }
    public void addRoleID(){
        System.out.println("Give role to account");
    }
}

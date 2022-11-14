// test AccountList
// 
// 
// 
// 
// 


package qlkh;
import java.util.Scanner;
import java.io.*;

public class login {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        File file = new File("D:\\PROJECT\\java\\khohang\\src\\qlkh\\account.txt");

        AccountList accountList = new AccountList();
        accountList.createList(file);
        System.out.println("***Storage Management System");

        // sign in section
        System.out.println("**Sign in");       
        System.out.print("Account name: ");
        String accountName = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        Account loginAccount = new Account(accountName, password);
        boolean check=accountList.checkSignIn(loginAccount);
        while(!check){
                System.out.println("Couldn't sign in. Please check your account name or your password.");
                System.out.print("Account name: ");
                accountName = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();
                loginAccount = new Account(accountName, password);
                check=accountList.checkSignIn(loginAccount);
        }
        loginAccount=accountList.giveLoginRoleID(loginAccount);
        System.out.println(loginAccount);

        Account a1 = new Account("adasda", "adfasdfasdf", "adfasfasdfas");
        accountList.addAccount(a1);
        accountList.displayList();
    } 
}
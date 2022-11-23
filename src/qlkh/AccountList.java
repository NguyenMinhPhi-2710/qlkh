package qlkh;

import java.io.*;
import java.util.Arrays;

public class AccountList {
    private Account[] list;

    public AccountList(){
        this.list=null;
    }
    public AccountList(Account[] list){
        this.list=list;
    }

    // create list and read data from file
    public void createList(File file){  
        list = new Account[0];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();

            while(line != null){
                String[] row = line.split(",");
                Account account = new Account(row[0], row[1], row[2]);
                account = giveRoleID(account, row[3]);
                list = addAccountFromFile(account, list);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file, using alternative solution instead.");

            Account account = new AdminAccount("admin", "123", "a001");
            account.addRoleID();
            list=addAccountFromFile(account, list);

            account = new StaffAccount("staff1", "123", "s001");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff2", "123", "s002");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff3", "123", "s003");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff4", "123", "s004");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff5", "123", "s005");
            account.addRoleID();
            list=addAccountFromFile(account,list);
            
            account = new StaffAccount("staff6", "123", "s006");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff7", "123", "s007");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff8", "123", "s008");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff9", "123", "s009");
            account.addRoleID();
            list=addAccountFromFile(account,list);

            account = new StaffAccount("staff10", "123", "s0010");
            account.addRoleID();
            list=addAccountFromFile(account,list);
        }
        finally{
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Cannot close the stream");
            }
        }
    }

    // override new data to file
    // MUST give this warning: "You MUST choose "Submit change & exit"(press _) to save all your changes"
    public void updataFile(File file){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file,false));
            for(Account account : list){
                bw.write(account.getAccountName() +",");
                bw.write(account.getPassword() +",");
                bw.write(account.getStaffID() +",");
                bw.write(account.getRoleID() +"\n");
            }
        } catch (IOException e) {
            System.out.println("Cannot update data!!");
        } finally{
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Cannot close the stream!!");
            }
        }
    }

    // this function is used for login class
    // it returns false when user give incorrect account name or password
    public boolean checkSignIn(Account account){
        for (Account a : list){
            if (account.getAccountName().equals(a.getAccountName())){
                if (account.getPassword().equals(a.getPassword())){
                    System.out.println("Sign in successfully!!");
                    return true;
                }
            }
        }
        return false;
    }

    public static Account[] addAccountFromFile(Account account, Account[] list){
        int n = list.length;
        list = Arrays.copyOf(list, n+1);
        list[n]=account;
        return list;
    }

    // add new account to list 
    public void addAccount(Account account){
        list = addAccountFromFile(account, list);
    }

    // remove account from list
    //                               accountName: name of the account that need to be deleted
    public void removeAccount(String accountName){

        if (list==null)
            System.out.println("No removal operation can be performed!!");
        else{
            Account[] proxyList = new Account[list.length-1];
            for (int i = 0, k = 0; i < list.length; i++){
                if (list[i].getAccountName().equals(accountName))
                    // ignore the account that need to be deleted
                    continue;
                else
                    try {
                        proxyList[k++]=list[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot remove the account!!");
                    }
            }
            System.out.println("Account removal has been performed!!");
            list = proxyList;
        }
    }

    // change account's password
    public void changePassword(String accountName,String oldPassword, String newPassword){
        for (int i=0;i<list.length;i++){
            if (list[i].getAccountName().equals(accountName)){
                if (list[i].getPassword().equals(oldPassword)){
                    list[i].setPassword(newPassword);
                    System.out.println("Password change has been performed!!\n***Don't forget your new password");
                    break;
                }
                else   
                    System.out.println("Incorrect password!!");
            }
            else
                System.out.println("Incorrect account name!!");
        }
    }

    // find account in list, ADMIN ACCESS ONLY
    public void findAccount(String accountName){
        for (Account account : list){
            if(account.getAccountName().equals(accountName)){
                System.out.println("Account found!!");
                System.out.println(account);
                break;
            }
            else 
                System.out.println("Cannot find account!!\n");
        }
    }

    // recheck the account type and recreate the account
    public Account giveRoleID(Account account, String roleID){
        if (roleID.equals("admin")){
            account = new AdminAccount(account.getAccountName(),account.getPassword(),account.getStaffID());
            account.addRoleID();
            return account;
        }
        else{
            account = new StaffAccount(account.getAccountName(),account.getPassword(),account.getStaffID());
            account.addRoleID();
            return account;
        }
    }

    // give the account in login class roleId to verify
    public Account giveLoginRoleID(Account account){
        for (Account a: list){
            if (account.getAccountName().equals(a.getAccountName())){
                account = new Account(a);
                System.out.println(account);
                account = giveRoleID(account, a.getRoleID());
                return account;
            }
        }
        return account;
    }

    // get the amount of account 
    public void getAmount(){
        System.out.println("Account amount: "+list.length);
    }

    public void displayList(){
        for(Account account : list){
            System.out.println(account);
        }
    }
}

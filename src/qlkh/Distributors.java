package qlkh;

import java.util.Scanner;
public class Distributors {
    Scanner sc = new Scanner(System.in);
    private String distributorID;
    private String distributorName;
    private Address distributorAddress;
    private String distributorPhoneNumber;

    public Distributors(){
        distributorID=null;
        distributorName=null;
        distributorAddress=null;
        distributorPhoneNumber=null;
    }
    public Distributors(String distributorID, String distributorName, Address distributorAddress, String distributorPhoneNumber){
        this.distributorID=distributorID;
        this.distributorName=distributorName;
        this.distributorAddress=distributorAddress;
        this.distributorPhoneNumber=distributorPhoneNumber;
    }
    public String getSupplierID(){
        return distributorID;
    }
    public void setSupplierID(){
        distributorID=sc.nextLine();
    }
    public String getSupplierName(){
        return distributorName;
    }
    public void setSupplierName(){
        distributorName=sc.nextLine();
    }
    public Address getSupplierAddress(){
        return distributorAddress;
    }
    public void setSupplierAddress(){
        distributorAddress.input();
    }
    public String getSupplierPhoneNumber(){
        return distributorPhoneNumber;
    }
    public void setSupplierPhoneNumber(){
        distributorPhoneNumber=sc.nextLine();
    }
    public String toString(){
        return distributorID +" " +distributorName +" " +distributorAddress +" " +distributorPhoneNumber;
    }
}

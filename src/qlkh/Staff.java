package qlkh;
import java.util.Scanner;

public class Staff {
    Scanner sc = new Scanner(System.in);
    protected String staffID;
    protected String staffName;
    protected Address address;
    protected String phoneNumber;
    protected String position;

    public Staff(){
        staffID=null;
        staffName=null;
        address = new Address();
        phoneNumber=null;
        position=null;
    }
    public Staff(String staffID, String staffName, Address address, String phoneNumber, String position){
        this.staffID = staffID;
        this.staffName = staffName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.position = position;

    }
    public String getStaffID(){
        return staffID;
    }
    public void setStaffID(){
        staffID = sc.nextLine();
    }
    public String getStaffName(){
        return staffName;
    }
    public void setStaffName(){
        staffName = sc.nextLine();
    }
    public Address getAddress(){
        return address;
    }
    public void setAddress(){
        address.input();
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(){
        phoneNumber = sc.nextLine();
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(){
        position = sc.nextLine();
    }
    public void input(){
        //System.out.print("Nhap ma nhan vien: ");
        setStaffID();
        // System.out.print("Nhap ten nhan vien: ");
        setStaffName();
        setAddress();
        //System.out.print("Nhap so dien thoai:");
        setPhoneNumber();
        //ystem.out.print("Nhap chuc vu: ");
        setPosition();
    }
    public String toString(){
        return staffID +" " +staffName +" " +address +" " +phoneNumber +" " +position;
    }
    public static void main(String[] args){
        Staff a = new Staff();
        a.input();
        System.out.println(a);
    }
}

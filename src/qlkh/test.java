package qlkh;

import java.io.*;

public class test {
    public static void main(String[] args) {
        File addressFile = new File("D:\\PROJECT\\java\\khohang\\src\\qlkh\\address.txt");
        File staffFile = new File("D:\\PROJECT\\java\\khohang\\src\\qlkh\\staff.txt");

        StaffList staffList = new StaffList();
        staffList.createList(staffFile, addressFile);
        staffList.displayList();
    }
}

// 
// 
// class test chuc nang StaffList
package qlkh;

import java.io.File;

public class test {
    public static void main(String[] args) {
        StaffList staffList = new StaffList();

        File addressFile = new File("address.txt");
        File staffFile = new File("staff.txt");

        staffList.createList(staffFile, addressFile);
        Staff a = new Staff("2323", "42343", null, "24234", "234243");
        staffList.addStaff(a);
        staffList.updataFile(staffFile, addressFile);
    }
}

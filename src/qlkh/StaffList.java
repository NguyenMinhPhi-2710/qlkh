package qlkh;
import java.util.Arrays;
import java.io.*;
public class StaffList {
    private static Staff[] list;

    public StaffList(){
        list=null;
    }
    public StaffList(Staff[] list){
        this.list=list;
    }

    // create list and read data from file
    public void createList(File staffFile,File addressFile){  
        list = new Staff[0];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(addressFile));
            String line = br.readLine();
            Address[] addressArray= new Address[0];
            while(line != null){
                String[] row = line.split(",");
                Address address = new Address(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
                addressArray=addAddressFromFile(address, addressArray);
                line = br.readLine();
            }
            br.close();

            br = new BufferedReader(new FileReader(staffFile));
            line = br.readLine();
            int index=0;
            while(line != null){
                String[] row = line.split(",");
                Staff staff = new Staff(row[0], row[1], addressArray[index], row[2], row[3]);
                list = addStaffFromFile(staff, list);
                index++;
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file, using alternative solution instead.");

            Address address = new Address(1,"Duong 1", "P1", "Q1", "TP Mong Mo");
            Staff staff = new Staff("staff1", "Nguyen Van A", address, "0123", "Quan ly");
            list=addStaffFromFile(staff, list);

            address = new Address(2,"Duong 2", "P2", "Q2", "TP Mong Mo");
            staff = new Staff("staff2", "Nguyen Van B", address, "0234", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(3,"Duong 3", "P3", "Q3", "TP Mong Mo");
            staff = new Staff("staff3", "Nguyen Van C", address, "0345", "Nhan vien");
            list=addStaffFromFile(staff, list);
            
            address = new Address(4,"Duong 4", "P4", "Q4", "TP Mong Mo");
            staff = new Staff("staff4", "Nguyen Van D", address, "0456", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(5,"Duong 5", "P5", "Q5", "TP Mong Mo");
            staff = new Staff("staff5", "Nguyen Van E", address, "0567", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(6,"Duong 6", "P6", "Q6", "TP Mong Mo");
            staff = new Staff("staff6", "Nguyen Van F", address, "0678", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(7,"Duong 7", "P7", "Q7", "TP Mong Mo");
            staff = new Staff("staff7", "Nguyen Van G", address, "0789", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(8,"Duong 8", "P8", "Q8", "TP Mong Mo");
            staff = new Staff("staff8", "Nguyen Van H", address, "0890", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(9,"Duong 9", "P9", "Q9", "TP Mong Mo");
            staff = new Staff("staff9", "Nguyen Van I", address, "0901", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(10,"Duong 10", "P10", "Q10", "TP Mong Mo");
            staff = new Staff("staff10", "Nguyen Van J", address, "0902", "Nhan vien");
            list=addStaffFromFile(staff, list);

            updataFile(staffFile, addressFile);
        }
        finally{
            try {
                if (br!=null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // read address date from file
    public static Address[] addAddressFromFile(Address address,Address[] arr){
        int n = arr.length;
        arr = Arrays.copyOf(arr, n+1);
        arr[n] = address;
        return arr;
    }

    //read staff data from file
    public static Staff[] addStaffFromFile(Staff staff,Staff[] arr){
        int n = arr.length;
        arr = Arrays.copyOf(arr, n+1);
        arr[n] = staff;
        return arr;
    }

    // add staff to list
    public void addStaff(Staff staff){
        list = addStaffFromFile(staff, list);
        System.out.println("Nhan vien da duoc them thanh cong!!");

    }

    // remove staff from list
    //                               staffName: name of the staff that need to be deleted
    public void removeStaff(String staffName){

        if (list==null)
            System.out.println("Khong ton tai danh sach");
        else{
            Staff[] proxyList = new Staff[list.length-1];
            for (int i = 0, k = 0; i < list.length; i++){
                if (list[i].getStaffName().equals(staffName))
                    // ignore the staff that need to be deleted
                    continue;
                else
                    try {
                        proxyList[k++]=list[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Khong tim thay nhan vien.");
                    }
            }
            list = proxyList;
        }
    }

    // override new data to file
    // MUST give this warning: "You MUST choose "Submit change & exit"(press _) to save all your changes"
    public static void updataFile(File staffFile, File addressFile){
        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;
        try {
            bw1 = new BufferedWriter(new FileWriter(staffFile,false));
            bw2 = new BufferedWriter(new FileWriter(addressFile,false));
            for(Staff staff : list){
                bw1.write(staff.getStaffID() +",");
                bw1.write(staff.getStaffName() +",");
                bw1.write(staff.getPhoneNumber() +",");
                bw1.write(staff.getPosition() +"\n");
                bw2.write(staff.getAddress() +"\n");
            }
        } catch (IOException e) {
            System.out.println("Cannot update data!!");
        } finally{
            try {
                if (bw1!=null && bw2!=null){
                    bw1.close();
                    bw2.close();
                }
            } catch (Exception e) {
                System.out.println("Cannot close the stream!!");
            }   
        }
    }

    // change staff information
    public void adjustStaff(String staffID){
        for (Staff staff : list){
            if(staff.getStaffID().equals(staffID)){
                staff.input();
            }
            else
                System.out.println("Khong the tim thay nhan vien.");
        }
    }

    // find staff
    public void findStaff(String staffID){
        for (Staff staff : list){
            if(staff.getStaffID().equals(staffID)){
                System.out.println("Nhan vien tim thay!!");
                System.out.println(staff);
            }
            else
                System.out.println("Khong the tim thay nhan vien.");
        }
    }

    // check staffID whether it exists or not
    public boolean checkStaff(String staffID){
        for (Staff staff : list){
            if(staff.getStaffID().equals(staffID))
                return true;
        }
        return false;
        
    }

    // get the amount of staff 
    public void getAmount(){
        System.out.println("Staff number: "+list.length);
    }

    public void displayList(){
        for(Staff staff : list)
            System.out.println(staff);
    }
}

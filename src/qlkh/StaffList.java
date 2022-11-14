package qlkh;
import java.util.Arrays;
import java.io.*;
public class StaffList {
    private Staff[] list;

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
            Staff staff = new Staff("a001", "Nguyen Van A", address, "0123", "Quan ly");
            list=addStaffFromFile(staff, list);

            address = new Address(2,"Duong 2", "P2", "Q2", "TP Mong Mo");
            staff = new Staff("a002", "Nguyen Van B", address, "0234", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(3,"Duong 3", "P3", "Q3", "TP Mong Mo");
            staff = new Staff("a003", "Nguyen Van C", address, "0345", "Nhan vien");
            list=addStaffFromFile(staff, list);
            
            address = new Address(4,"Duong 4", "P4", "Q4", "TP Mong Mo");
            staff = new Staff("a004", "Nguyen Van D", address, "0456", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(5,"Duong 5", "P5", "Q5", "TP Mong Mo");
            staff = new Staff("a005", "Nguyen Van E", address, "0567", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(6,"Duong 6", "P6", "Q6", "TP Mong Mo");
            staff = new Staff("a006", "Nguyen Van F", address, "0678", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(7,"Duong 7", "P7", "Q7", "TP Mong Mo");
            staff = new Staff("a007", "Nguyen Van G", address, "0789", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(8,"Duong 8", "P8", "Q8", "TP Mong Mo");
            staff = new Staff("a008", "Nguyen Van H", address, "0890", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(9,"Duong 9", "P9", "Q9", "TP Mong Mo");
            staff = new Staff("a009", "Nguyen Van I", address, "0901", "Nhan vien");
            list=addStaffFromFile(staff, list);

            address = new Address(10,"Duong 10", "P10", "Q10", "TP Mong Mo");
            staff = new Staff("a0010", "Nguyen Van J", address, "0902", "Nhan vien");
            list=addStaffFromFile(staff, list);
        }
        finally{
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Cannot close the stream");
            }
        }
    }

    public static Address[] addAddressFromFile(Address address,Address[] arr){
        int n = arr.length;
        arr = Arrays.copyOf(arr, n+1);
        arr[n] = address;
        return arr;
    }

    //read address data from file
    public static Staff[] addStaffFromFile(Staff staff,Staff[] arr){
        int n = arr.length;
        arr = Arrays.copyOf(arr, n+1);
        arr[n] = staff;
        return arr;
    }

    // add staff to list
    public void addStaff(Staff staff){
        list = addStaffFromFile(staff, list);
    }

    // remove staff from list
    //                               staffName: name of the staff that need to be deleted
    public void removeStaff(String staffName){

        if (list==null)
            System.out.println("No removal operation can be performed!!");
        else{
            Staff[] proxyList = new Staff[list.length-1];
            for (int i = 0, k = 0; i < list.length; i++){
                if (list[i].staffName.equals(staffName))
                    // ignore the staff that need to be deleted
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

    //Uncompleted
    public void adjustStaff(String staffID){
        for (Staff staff : list){
            if(staff.staffID.equals(staffID)){
                staff.input();
            }
            else
                System.out.println("Couldn't find staff");
        }
    }

    // find staff
    public void findStaff(String staffID){
        for (Staff staff : list){
            if(staff.staffID.equals(staffID)){
                System.out.println(staff);
            }
            else
                System.out.println("Couldn't find staff");
        }
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

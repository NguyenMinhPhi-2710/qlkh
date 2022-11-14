package qlkh;

public class StaffAccount extends Account {
    
    public StaffAccount(){
        super();
    }
    public StaffAccount(String taiKhoan, String matKhau, String maNV){
        super(taiKhoan,matKhau,maNV);
    }
    public StaffAccount(StaffAccount account){
        super(account);
    }
    @Override
    public void addRoleID(){
        roleID="staff";
    }
    @Override
    public String toString(){
        return accountName +" " +password +" " +staffID +" " +roleID; 
    }
}

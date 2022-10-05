package bankingsystem;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginController extends Customer{

      private HashMap<Long,String>  adminCheck=new HashMap<>();
    public  boolean nameCheck(String userName)
    {
        return Pattern.matches("[A-Z][^0-9]+", userName);
    }

    public  boolean mobileNumberCheck(String mobileno)
    {
        return Pattern.matches("[0-9]{10}", mobileno);
    }
    public LoginController(){
        super();

    }
    public boolean passwordCheck(String password)
    {
        return Pattern.matches("[^0-9][a-z,A-Z,0-9]{7,}", password);
    }

    public boolean adminPasswordCheck(long adminId,String adminPassword)
    {

             if(adminCheck.get(adminId).equals(adminPassword))
             {
                 return true;
             }
             else System.out.println("Password Wrong");
             return false;


    }
    public boolean adminIdCheck(long adminId)
    {
       return adminCheck.containsKey(adminId) ;
    }
    public  void adminSet()
    {
        adminCheck.put(12345l,"hentry123");
    }
    public void addAdmin()
    {
        long adminId=0;
        String adminPassword;
        System.out.println("Enter the admin Id");
        adminId=scan.nextLong();
        System.out.println("Enter the admin Password");
        adminPassword=scan.next();
        if(adminCheck.containsKey(adminId)){
            System.out.println("Already Here");return;}
        adminCheck.putIfAbsent(adminId,adminPassword);
        System.out.println("Admin Added SuccessFully");

    }
}

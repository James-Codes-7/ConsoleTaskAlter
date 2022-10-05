package bankingsystem;

import java.util.Scanner;

public class AccountCreationCheck  extends  Login{

    Boolean bool=true;

    byte option=1;

   public String namePage()
   {
       System.out.println("Enter the customer name");
       System.out.println("The First letter must be Captital And only use letters");
       String userName="";
       option=1;
       bool=true;
       scan.nextLine();
       f1:while(bool)
       {

           userName=scan.nextLine();
           while(nameCheck(userName)&&option==1)
           {
               System.out.println("Your Name is:"+userName);
               System.out.println("If you want change name    Press 1 else 0");
               option=scan.nextByte();
               if(option==1) {System.out.println("Re -Enter the name");scan.nextLine();}
               else {bool=false ;continue f1;}
           }
           System.out.println("Enter the Correct format");

       }
       return userName;
   }
   public  String passwordPage()
   {
       bool=true;
       String password="";
       System.out.println("Enter the Password");
       System.out.println("The Password must be above 8 charcters");
       while(bool)
       {
           password=scan.next();
           if(passwordCheck(password))
           {
               bool=false;
               break;
           }
           else
               System.out.println("Re-Enter the password");
       }
       return  password;
   }
   public String mobileNoPage()
   {
       String mobileno="";
       bool=true;
       option=1;
       System.out.println("Enter the mobileNo");
       System.out.println("Only put numbers and 10 digits only allowed");
       while(bool)
       {
           mobileno=scan.next();
           if(mobileNumberCheck(mobileno))
           {
               System.out.println("Your mobile no:"+mobileno);
               System.out.println("If you want change   Press 1 else 0");
               option=scan.nextByte();
               if(option==1) {System.out.println("Re -enter the mobile no");continue;}
               else {bool=false;break;}
           }
           System.out.println("Enter the correct format");
       }
       return mobileno;
   }
   public long initialAmountPage()
   {
       long initialAmount=0;
       bool=true;
        option=0;
       System.out.println("Enter the initial Amount");
       System.out.println("Only accepted if amount greater than five hundred");
       while(bool)
       {
           initialAmount=scan.nextLong();
           if(initialAmount>500)
           {
               System.out.println("If you want change intial amount    Press 1 else 0");
               option=scan.nextByte();
               if(option==1) {System.out.println("Re -Enter the initial amount");continue;}
               else {bool=false;break;}

           }
           else
           {System.out.println("Enter the valid amount");}
       }
       return initialAmount;
   }
}

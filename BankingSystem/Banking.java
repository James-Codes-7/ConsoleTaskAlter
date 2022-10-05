package bankingsystem;

import java.util.Scanner;

public class Banking extends  AdminSite{

    Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        Banking banking=new Banking();
        banking.frontPage();

    }
    public  void frontPage()
    {
        System.out.println("Welcome to Banking System");
        boolean iterate=true;
        int option=0;
        while(iterate)
        {
            System.out.println("Admin       Press 1");
            System.out.println("Customer    Press 2");
            System.out.println("Exit        Press 3");
            System.out.println("Enter the option");
            option=scan.nextInt();
            if(option==3) {iterate=false;break;}
            switch(option)
            {
                case 1:adminView();
                break;
                case 2:clientView();
                    break;
                default :System.out.println("Enter the correct one");
                    System.out.println();
            }
        }
    }

}

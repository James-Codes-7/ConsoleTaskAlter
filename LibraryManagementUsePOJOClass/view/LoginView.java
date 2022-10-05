package view;

import java.util.Scanner;
import controler.LoginController;
public class LoginView {
    private Scanner scanner = new Scanner(System.in);
    private LoginController loginControler;
    private ManageBooks manageBooks;
    private ManageUsers manageUsers;

    LoginView() {
        loginControler = new LoginController();
        manageBooks=new ManageBooks();
        manageUsers=new ManageUsers();

    }

    private void initLogin() {
        System.out.println("Welcome to Library Management System\n ------------------------");
        checkForLogin();
    }

    private void checkForLogin() {
        System.out.println("Enter User Name");
        String userName = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        if (loginControler.checkCredentials(userName, password)) {
            System.out.println("\n-->Welcome "+userName+"<--\n");
            SetupLibrary setupLibrary = new SetupLibrary();
            setupLibrary.init();
            viewPage();

        } else {
            System.out.println("\nInvalid Credentials. Please try again!\n");
            checkForLogin();
        }
    }

    static public void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.initLogin();
    }
    private void viewPage()
    {
        boolean bool=true;
        byte option=0;
        while(bool)
        {
            System.out.println("User Info           Press 1");
            System.out.println("Book Info           Press 2");
            System.out.println("Exit                Press 3");
            System.out.println("Enter the option");
            option= scanner.nextByte();
            if(option==3){bool=false;return;}
            switch(option)
            {
                case 1:manageUsers.userInfo();
                break;
                case 2:manageBooks.bookInfo();
                break;
                default:System.out.println("Enter the valid one");
            }
        }
    }
}

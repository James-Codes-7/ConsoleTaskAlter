package bankingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Login extends CustomerTransactions{

    public  void customerLogin(ArrayList<Customer> customerDetails) {
        Scanner scan = new Scanner(System.in);
        long accountNo = -1;
        String password = "";
        boolean bool = true;
        int limit=3;
        byte passwordwrongcheck = 0;
        System.out.println("Enter the Account number");
        f1:
        while (bool) {
            accountNo = scan.nextLong();
            while (loginCheck.containsKey(accountNo)) {
                System.out.println("Enter the correct password here");
                password = scan.next();
                if (password.equals(loginCheck.get(accountNo))) {
                    bool = false;
                    break f1;
                }
                passwordwrongcheck++;
                if (passwordwrongcheck == limit) {
                    goToPasswordChange(customerDetails, accountNo);
                    passwordwrongcheck = 0;
                }
            }
            System.out.println("Enter the correct account no");
        }

        transferPage(accountNo,customerDetails);
    }
}

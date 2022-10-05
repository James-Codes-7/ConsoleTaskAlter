package bankingsystem;


import java.util.ArrayList;

public class PasswordChanging extends LoginController {
    public void goToPasswordChange(ArrayList<Customer> customerDetails
            , long accountno) {
        System.out.println("Please Change your password");
        System.out.println();
        String phoneno = "";
        boolean bool = true;
        String password = "";
        System.out.println("Enter Your phone number");
        while (bool) {
            phoneno = scan.next();
            while (passwordChange.get(accountno).equals(phoneno)) {
                System.out.println("Enter the new password");
                password = scan.next();
                if (passwordCheck(password)) {
                    passwordChanging(customerDetails, accountno, password);
                    System.out.println("Password Succesfully Changed");
                    return;
                } else {
                    System.out.println("Re enter Password");
                    System.out.println();
                }
            }
        }
    }

        public void passwordChanging (ArrayList < Customer> customerDetails,
        long accountno, String password)
        {
            for (Customer changeProcess : customerDetails) {
                if (changeProcess.accountNo == accountno) {
                    changeProcess.password = password;
                    return;
                }
            }
        }



}

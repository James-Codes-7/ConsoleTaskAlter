package bankingsystem;


import java.util.ArrayList;


public class CustomerSite extends AccountCreationCheck {


    public CustomerSite() {
        super();
    }

    public  long generateAccountNumber=1;

    private  int accountCreate(ArrayList<Customer> customerDetails)
    {
        boolean bool=true;
        String userName=namePage();
        String password=passwordPage();
        String mobileno=mobileNoPage();
        long initialAmount=initialAmountPage();
        byte option=1;
        System.out.println("Your Account number is:"+generateAccountNumber);

        loginCheck.put(generateAccountNumber, password);
        passwordChange.put(generateAccountNumber, mobileno);
        System.out.println("Your Account is created...");
        customerDetails.add(new Customer(userName,password,generateAccountNumber++,initialAmount,java.time.LocalDate.now(),
                mobileno));
        System.out.println();
        return 1;

    }
    public  void clientView()
    {
        boolean iterate=true;
        int check=0,option=0;

        while(iterate)
        {
            System.out.println("Account Create    Press 1");
            System.out.println("Login             Press 2");
            System.out.println("Exit              Press 3");
            System.out.println("Enter the option");
            option=scan.nextInt();
            if(option==3)return;
            switch(option)
            {
                case 1:check=accountCreate(customerDetails);
                    break;
                case 2:if(check!=0)
                {customerLogin(customerDetails);
                    break;}
                default :System.out.println("Enter the correct option");
                    System.out.println();
            }

        }
    }

}

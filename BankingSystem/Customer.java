package bankingsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer extends AccountTransfer{

    Scanner scan=new Scanner(System.in);
    public String userName;
    public String password;
    public long accountNo;
    public long accountBalance;
    public LocalDate date;
    public String mobileNo;
    HashMap<Long,String> loginCheck=new HashMap<>();
    HashMap<Long,String> passwordChange=new HashMap<>();
    ArrayList<Customer> customerDetails=new ArrayList<>();
    public Customer(String userName, String password,long accountNo,long accountBalance,
                        LocalDate date, String mobileNo)
    {
        this.userName=userName;
        this.password=password;
        this.accountNo=accountNo;
        this.accountBalance=accountBalance;
        this.date=date;
        this.mobileNo=mobileNo;
    }

    public Customer() {

    }
}

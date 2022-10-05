package bankingsystem;

import java.util.ArrayList;
import java.util.HashMap;


public class CustomerTransactions extends PasswordChanging {

     ArrayList<SelfDeposit> depositeHistory=new ArrayList<>();
    ArrayList<AccountTransfer> accountTransferHistory=new ArrayList<>();
    private void balanceCheck(long accountno
                              ,
                                    ArrayList<Customer> customerDetails)
    {
        for(Customer balanceView:customerDetails)
        {
            if(balanceView.accountNo==accountno)
            {
                System.out.println("Your Account balance is:"+balanceView.accountBalance);
                System.out.println();
                return;
            }
        }
    }
    private  void depositMoney(long accountno
            ,ArrayList<Customer> customerDetails)
    {
        long amount=0;
        boolean bool=true;
        byte option=0;
        System.out.println("Enter the amount");
        bool=true;
        while(bool)
        {
            amount=scan.nextLong();
            System.out.println("If you want change amount Press 1 else 0");
            option=scan.nextByte();
            if(option==1) {System.out.println("Re-Enter amount");System.out.println();}
            else break;
        }
        for(Customer moneyAdd:customerDetails)
        {
            if(moneyAdd.accountNo==accountno)
            {
                moneyAdd.accountBalance+=amount;
                System.out.println("Amount is SuccessFully added");
                depositeHistory.add(new SelfDeposit(accountno, amount,
                        java.time.LocalDate.now(), "Depostited",moneyAdd.accountBalance));
                System.out.println();
                return;
            }
        }



    }
    private  void accountTransfer(long accountno
            , ArrayList<Customer> customerDetails, HashMap<Long,String> loginCheck)
    {
        long amount=0;
        boolean bool=true;
        byte option=0;
        long receiverAccountNumber=0;
        System.out.println("Enter the Receive Customer Account no");

        while(bool)
        {
            receiverAccountNumber=scan.nextLong();
            if(receiverAccountNumberCheck(receiverAccountNumber, loginCheck))
            {
                System.out.println("The receiver Account number:"+receiverAccountNumber);
                System.out.println("If you want change receiver Account No  Press 1 else 0");
                option=scan.nextByte();
                if(option==1) {System.out.println("Re-Enter the accountno");continue;}
                else {bool=false;break;}
            }
            else System.out.println("Enter the correct receiver Account number");
        }
        System.out.println("Enter the Transfer Amount");
        bool=true;

        amount=scan.nextLong();
        long withdrawBalance=0;
        long receiverbalance=0;
        if(!transferAmountCheck( customerDetails,amount,accountno))
        {
            for(Customer moneyTransfer:customerDetails)
            {
                if(moneyTransfer.accountNo==receiverAccountNumber)
                {
                    moneyTransfer.accountBalance+=amount;
                    receiverbalance=moneyTransfer.accountBalance;
                }
                if(moneyTransfer.accountNo==accountno)
                {
                    moneyTransfer.accountBalance-=amount;
                    withdrawBalance=moneyTransfer.accountBalance;


                }
            }
        }
        else return;
        accountTransferHistory.add(new AccountTransfer(accountno,
                receiverAccountNumber,amount, withdrawBalance,  "Withdrawed",
                java.time.LocalDate.now()));
        depositeHistory.add(new SelfDeposit(receiverAccountNumber,amount, java.time.LocalDate.now(),
                "Deposited",  receiverbalance));
        System.out.println("Transactions successfullly completed");
        System.out.println();

    }
    private  boolean receiverAccountNumberCheck(long receiveraccountno,
                                                HashMap<Long,String> loginCheck)

    {
        return loginCheck.containsKey(receiveraccountno);
    }
    private  boolean transferAmountCheck(ArrayList<Customer> customerDetails,
                                         long amount,long accountno)
    {
        for(Customer amountCheck:customerDetails)
        {
            if(accountno==amountCheck.accountNo)
            {
                if(amount>amountCheck.accountBalance)
                {
                    System.out.println("Insufficient Balance");
                    return true;
                }
            }
        }
        return false;
    }
    private   void viewTransactionsHistory(long AccountNo)
    {
        System.out.println("Deposit History");
        System.out.println();

        for(SelfDeposit depositeDetails:depositeHistory)
        {
            if(AccountNo==depositeDetails.Selfaccountno)
            {
                System.out.println("Account No:     "+depositeDetails.Selfaccountno);
                System.out.println("Deposite Amount:"+depositeDetails.depositAmount);
                System.out.println("Deposite Time:  "+depositeDetails.depositDate);
                System.out.println("Account balance:"+depositeDetails.selfaccountBalance);
                System.out.println("Status:         "+depositeDetails.transferType);


            }
            System.out.println();
        }
        System.out.println("Account Transfer History");
        System.out.println();
        for(AccountTransfer accountTransferHistory:accountTransferHistory)
        {
            if(AccountNo==accountTransferHistory.userAccountNo)
            {
                System.out.println("Account No:       "+accountTransferHistory.userAccountNo);
                System.out.println("ReceiverAccountNo:"+accountTransferHistory.receiverAccountNo);
                System.out.println("Transfer Amount:  "+accountTransferHistory.withDrawAmount);
                System.out.println("Withdraw Date:    "+accountTransferHistory.withdrawDate);
                System.out.println("Account balance:  "+accountTransferHistory.transferbalanceAmount);
                System.out.println("Status:           "+accountTransferHistory.status);


            }
            System.out.println();
        }
    }
    public void transferPage(long accountNo,ArrayList<Customer> customerDetails)
    {
        boolean bool=true;
        byte option=0;
        while(bool)
        {


            System.out.println("View Account Balance      Press 1");
            System.out.println("Deposit Money             Press 2");
            System.out.println("Account Transfer          Press 3");
            System.out.println("Transactions History      Press 4");
            System.out.println("Exit                      Press 5");
            option=scan.nextByte();
            switch(option)
            {
                case 1:balanceCheck(accountNo,customerDetails);
                    break;
                case 2:depositMoney(accountNo,customerDetails);
                    break;
                case 3:accountTransfer(accountNo,
                        customerDetails,loginCheck);break;
                case 4:viewTransactionsHistory(accountNo);break;
                case 5:return;
            }
            System.out.println();

        }
    }

    public void adminWrites()
    {
        boolean bool=true;
       byte option=1;

        while (bool)
        {
            System.out.println("View CustomerList                    Press 1");
            System.out.println("Single Cusotmer Profile              Press 2");
            System.out.println("View Whole Transactions              Press 3");
            System.out.println("View Single user Transanction        Press 4");
            System.out.println("Exit                                 Press 5");
            option=scan.nextByte();
            if(option==5){bool=false;return;}
            switch(option)
            {
                case 1:viewCustomerList();
                break;
                case 2:singleCustomerProfile();
                break;
                case 3:viewWholeTransactions();
                break;
                case 4:singleUserTransactionHistory();
                break;
                default:
                    System.out.println("Enter the valid one");
            }
        }
    }
    private void viewCustomerList()
    {
        for(Customer customer:customerDetails)
        {
            System.out.println("Account No:"+customer.accountNo);
            System.out.println("User Name:"+customer.userName);
            System.out.println("Mobile No:"+customer.mobileNo);
            System.out.println("Account Create Date:"+customer.date);
            System.out.println("Account Balance:"+customer.accountBalance);
            System.out.println();
        }
    }
    private void singleCustomerProfile()
    {
        System.out.println("Enter the account number");
        long singleAccountno=scan.nextLong();
        for(Customer customer:customerDetails)
        {
            if(singleAccountno==customer.accountNo) {
                System.out.println("Account No:" + customer.accountNo);
                System.out.println("User Name:" + customer.userName);
                System.out.println("Mobile No:" + customer.mobileNo);
                System.out.println("Account Create Date:" + customer.date);
                System.out.println("Account Balance:" + customer.accountBalance);
                System.out.println();
                return;
            }
        }
        System.out.println("Enter the correct Customer accountno");
        return;
    }
    private void viewWholeTransactions()
    {

        System.out.println("Deposit    History");
        System.out.println();
        for(SelfDeposit depositeDetails:depositeHistory)
        {
                System.out.println("Account No:     "+depositeDetails.Selfaccountno);
                System.out.println("Deposite Amount:"+depositeDetails.depositAmount);
                System.out.println("Deposite Time:  "+depositeDetails.depositDate);
                System.out.println("Account balance:"+depositeDetails.selfaccountBalance);
                System.out.println("Status:         "+depositeDetails.transferType);

            System.out.println();
        }

        System.out.println();
        System.out.println("Account transfer History");
        System.out.println();
        for(AccountTransfer accountTransferHistory:accountTransferHistory)
        {

                System.out.println("Account No:       "+accountTransferHistory.userAccountNo);
                System.out.println("ReceiverAccountNo:"+accountTransferHistory.receiverAccountNo);
                System.out.println("Transfer Amount:  "+accountTransferHistory.withDrawAmount);
                System.out.println("Withdraw Date:    "+accountTransferHistory.withdrawDate);
                System.out.println("Account balance:  "+accountTransferHistory.transferbalanceAmount);
                System.out.println("Status:           "+accountTransferHistory.status);
            System.out.println();
        }
    }
    private void singleUserTransactionHistory()
    {
        System.out.println("Enter the account no");
        long singleAccountno=scan.nextLong();
        viewTransactionsHistory(singleAccountno);
    }
}


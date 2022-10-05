package bankingsystem;

import java.time.LocalDate;

public class AccountTransfer extends SelfDeposit{


    long userAccountNo;
    long receiverAccountNo;
    long withDrawAmount;
    long transferbalanceAmount;
    String status;
    LocalDate withdrawDate;
    public AccountTransfer(long userAccountno,long receiverAccountno,
                           long withdrawAmount,long balanceAmount,String status,LocalDate  date)
    {
        this.userAccountNo=userAccountno;
        this.receiverAccountNo=receiverAccountno;
        this.withDrawAmount=withdrawAmount;
        this.transferbalanceAmount=balanceAmount;
        this.status=status;
        this.withdrawDate=date;
    }
    public AccountTransfer()
    {

    }


}

package bankingsystem;

import java.time.LocalDate;

public class SelfDeposit {

    long Selfaccountno;
    long depositAmount;
    LocalDate depositDate;
    String transferType;
    long selfaccountBalance;
    public SelfDeposit(long accountno,long depositeAmount,LocalDate depositeDate,
                          String type,long accountBalance)
    {
        this. Selfaccountno=accountno;
        this. depositAmount=depositeAmount;
        this. depositDate=depositeDate;
        this.transferType=type;
        this.selfaccountBalance=accountBalance;
    }
    public  SelfDeposit(){}

}

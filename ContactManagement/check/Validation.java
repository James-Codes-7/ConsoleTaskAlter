package check;

import java.util.regex.Pattern;

public class Validation {

    private static Validation validation=null;
    public boolean phoneNumberValidation(long phoneNo)
    {
        Long tempNo=phoneNo;
        return Pattern.matches("[0-9]{10}",tempNo.toString());
    }

    public static Validation getInstance()
    {
        if(validation==null)validation=new Validation();
        return validation;
    }

}

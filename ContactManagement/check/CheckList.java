package check;

import model.Contact;
import model.ContactDatabase;

import java.util.List;

public class CheckList {

    private static  CheckList checkList= null;
    private ContactDatabase contactDatabase;
    public boolean previousNameCheck(String contactName)
    {
        List<Contact> contactList=contactDatabase.getContactList();
        for(Contact contact:contactList)
        {
            if(contact.getContactName().equals(contactName)) {
              return true;
            }

        }
        return false;
    }
    public  Boolean previousPhoneNoCheck(long phoneNo)
    {
        List<Contact> contactList=contactDatabase.getContactList();
        for(Contact contact:contactList)
        {
            if(contact.getContactName().equals(phoneNo)) {
                return true;
            }

        }
        return false;
    }
    public boolean previousMailIdCheck(String mailId)
    {
        List<Contact> contactList=contactDatabase.getContactList();
        for(Contact contact:contactList)
        {
            if(contact.getContactName().equals(mailId)) {
                return true;
            }

        }
        return false;
    }

    public  CheckList()
    {
        contactDatabase=ContactDatabase.getInstance();
    }
    public  static  CheckList getInstance()
    {
        if(checkList==null)checkList=new CheckList();
        return checkList;
    }

}

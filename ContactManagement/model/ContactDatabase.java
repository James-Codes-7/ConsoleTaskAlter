package model;

import java.util.ArrayList;
import java.util.List;

public class ContactDatabase {

  private static ContactDatabase contactDatabase=null;
  private  List<Contact> contactList;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList.addAll(contactList);
    }

    public  void setContactList(Contact contact)
    {
        this.contactList.add(contact);
    }

    public ContactDatabase()
    {
        contactList=new ArrayList<>();
    }

    public  static ContactDatabase getInstance()
    {
        if(contactDatabase==null)
        {
            contactDatabase=new ContactDatabase();
        }
        return  contactDatabase;
    }
}

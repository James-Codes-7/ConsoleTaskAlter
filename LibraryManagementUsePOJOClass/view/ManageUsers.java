package view;

import controler.ManageUserController;
import model.BookTransactions;
import model.LibraryDatabase;
import model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ManageUsers {

   private  LibraryDatabase libraryDatabase;
    private ManageUserController checkList;
    Scanner scanner=new Scanner(System.in);

    public void userInfo()
    {
       boolean bool=true;
       int option=0;
       while(bool)
       {
           System.out.println();
           System.out.println("View Customer List        Press 1");
           System.out.println("Add Customer              Press 2");
           System.out.println("Assign the book           Press 3");
           System.out.println("Return the  book          Press 4");
           System.out.println("User Fine Pay             Press 5");
           System.out.println("View Book Assign List     Press 6");
           System.out.println("View Book return List     Press 7");
           System.out.println("Exit                      Press 8");
           System.out.println("Enter the option");
           option=scanner.nextInt();
           if(option==8){bool=false;return;}
           switch(option)
           {
               case 1:viewCustomerList();
               break;
               case 2:addCustomer();
               break;
               case 3:assignTheBook();
               break;
               case 4:returnTheBook();
               break;
               case 5:userFinePay();
               break;
               case 6:viewBookAssignList();
               break;
               case 7:viewBookReturnList();
               break;
               default:
                   System.out.println("Enter the valid one");
           }
       }

    }
    public void viewBookReturnList()
    {
        List<BookTransactions> bookTransactions=libraryDatabase.getBookTransaction();
        for(BookTransactions bookTraverse:bookTransactions)
        {
            if(bookTraverse.isReturned()) {
                System.out.println("Book Id:                  "+bookTraverse.getBookId());
                System.out.println("User Id:                  "+bookTraverse.getUserId());
                System.out.println("Borowed Date:             "+dateFormat(bookTraverse.getDateBorrowed()));
                System.out.println("Date to be return:        "+dateFormat(bookTraverse.getDateToBeReturn()));
                if(bookTraverse.isFined())
                {
                    System.out.println("The book is Fined:        "+bookTraverse.isFined());
                    System.out.println("Fine Amount:              "+bookTraverse.getFineAmount());
                    System.out.println("The fine Is Paid:         "+bookTraverse.isPaied());
                    System.out.println("The Fine date:            "+dateFormat(bookTraverse.getFinedDate()));
                    System.out.println("The Fine Due Date:        "+dateFormat(bookTraverse.getFineDueDate()));
                    System.out.println("The Fine Paid Date:       "+dateFormat(bookTraverse.getFinePaidDate()));

                }
                    System.out.println("The Book Return date:     "+dateFormat(bookTraverse.getReturnedDate()));
            }
        }
    }
    private void viewBookAssignList()
    {
        List<BookTransactions> bookTransactions=libraryDatabase.getBookTransaction();
        for(BookTransactions bookTraverse:bookTransactions)
        {
            if(!bookTraverse.isReturned()) {
                System.out.println("Book Id:                  "+bookTraverse.getBookId());
                System.out.println("User Id:                  "+bookTraverse.getUserId());
                System.out.println("Borowed Date:             "+dateFormat(bookTraverse.getDateBorrowed()));
                System.out.println("Date to be return:        "+dateFormat(bookTraverse.getDateToBeReturn()));
                System.out.println();
            }
        }
    }
    private void userFinePay()
    {
        byte option=0;
        boolean valid=true;
        System.out.println("Enter the User Id");
        int userId=scanner.nextInt();
        if(!checkList.userIdCheck(userId)){
            System.out.println("Wrong user ID");
        }
        System.out.println("Enter the book Id");
        long bookId= scanner.nextLong();
       if(!checkList.bookIdCheck(bookId)){
           System.out.println("Worng Book Id");}
        BookTransactions bookTransactions =getBookTransactions(userId,bookId);
        if(bookTransactions==null){return;}
        if(!bookTransactions.isPaied()) {
            System.out.println("Your Fine Amount:" + bookTransactions.getFineAmount());
            System.out.println("Press 1 for paid");
            option = scanner.nextByte();
            if (option == 1) {

                    bookTransactions.setPaied(!bookTransactions.isPaied());

                long finedDate = scanner.nextLong();
                bookTransactions.setFinedDate(finedDate);
                System.out.println("Enter the fine due Date");
                long fineDueDate = scanner.nextLong();
                bookTransactions.setFineDueDate(fineDueDate);
                System.out.println("Enter the fine Paid Date");
                long finePaidDate = scanner.nextLong();
                bookTransactions.setFinePaidDate(finePaidDate);
                bookTransactions.setReturned(valid);
                bookTransactions.setReturnedDate(System.currentTimeMillis());
                checkList.getBookInstance(bookId).setAvailablity(valid);
                System.out.println("Fine Paid SucessFully");
            } else System.out.println("Fine not Paid");

        }

    }
    private BookTransactions getBookTransactions(int userId,long booKId)
    {
        List<BookTransactions> bookTransactions=libraryDatabase.getBookTransaction();
        for(BookTransactions bookTraverse:bookTransactions)
        {
            if(bookTraverse.getBookId()==booKId&&bookTraverse.getUserId()==userId&&!bookTraverse.isReturned()
            &&bookTraverse.getFineAmount()>0&&!bookTraverse.isPaied())
            {
                return bookTraverse;
            }
        }
        return null;
    }


    private void assignTheBook()
    {
        boolean valid=false;
        BookTransactions bookTransactions=new BookTransactions();
        System.out.println("Enter the book Id");
        long bookId=scanner.nextLong();
        if(!checkList.bookAvailabiltyCheck(bookId)){
            System.out.println("Book is not available");return;}
        System.out.println("Enter the user Id");
        int userId=scanner.nextInt();
        if(!checkList.userIdCheck(userId)){
            System.out.println("Wrong user ID");
        }
        if(checkList.previousFineAmountCheck(userId))return;

        long dateBorrowed=System.currentTimeMillis();

        long dateToBeReturn= dateBorrowed+TimeUnit.DAYS.toMillis(15);
        bookTransactions.setBookId(bookId);
        bookTransactions.setUserId(userId);
        bookTransactions.setDateBorrowed(dateBorrowed);
        bookTransactions.setDateToBeReturn(dateToBeReturn);
        bookTransactions.setReturned(valid);
        libraryDatabase.insertBookTransaction(bookTransactions);
        checkList.getBookInstance(bookId).setAvailablity(valid);
        System.out.println("Book Assign Successfully");
    }
    private void  returnTheBook()
    {
        boolean valid=true;
        BookTransactions bookTransactions;
        System.out.println("Enter the book Id");
        long bookId=scanner.nextLong();
        System.out.println("Enter the user Id");
        int userId=scanner.nextInt();
        bookTransactions=checkList.bookTransactionCheck(bookId,userId);
        if(bookTransactions==null)return;
        System.out.println("The book is Fined");
        boolean isFined=scanner.nextBoolean();
        bookTransactions.setFined(isFined);
        boolean isPaied=false;
        if(isFined==valid) {
            System.out.println("Enter the fine Amount");
            int fineAmount = scanner.nextInt();
            bookTransactions.setFineAmount(fineAmount);
            System.out.println("The  fine is Paid");
             isPaied=scanner.nextBoolean();
             bookTransactions.setPaied(isPaied);
            long finedDate = System.currentTimeMillis();
            bookTransactions.setFinedDate(finedDate);
            System.out.println("Your Fine Date:"+java.time.LocalDate.now());

            long fineDueDate =finedDate+TimeUnit.DAYS.toMillis(5);
            bookTransactions.setFineDueDate(fineDueDate);
            System.out.println("Your Fine Due Date:"+dateFormat(fineDueDate));

            if(isPaied) {
                long finePaidDate=System.currentTimeMillis();
                bookTransactions.setFinePaidDate(finePaidDate);
               System.out.println("Your Fine Paid Date:"+dateFormat(finePaidDate));
               bookTransactions.setReturnedDate(System.currentTimeMillis());
                checkList.getBookInstance(bookId).setAvailablity(valid);
            }
        }
        boolean isReturned=(isFined&&isPaied)||!isFined;
        bookTransactions.setReturned(isReturned);
        if(isReturned)
        {
        System.out.println("Book is returned");}
        else System.out.println("Please pay the fine after your book is returned");
    }


    private void addCustomer()
    {
        User user=new User();
        System.out.println("Enter the UserId");
        int userID=scanner.nextInt();
        System.out.println("Enter the user Name");
        scanner.nextLine();
        String userName= scanner.nextLine();
        System.out.println("Enter the Phone No");
        long phoneNo=scanner.nextLong();
        System.out.println("Enter the email ID");
         String emailId=scanner.next();
        System.out.println("Enter the Address");
        scanner.nextLine();
        String address=scanner.nextLine();
        System.out.println("Member Ship availablity");
        boolean hasMembership=scanner.nextBoolean();
        user.setUserId(userID);
        user.setUserName(userName);
        user.setPhoneNo(phoneNo);
        user.setEmailId(emailId);
        user.setAddress(address);
        user.setHasMembership(hasMembership);
        libraryDatabase.insertUserList(user);
        System.out.println("SuccessFully add CustomerList");

    }
    private void viewCustomerList()
    {
      List<User>  userList= libraryDatabase.getUserList();
      for(User user:userList)
      {
          System.out.println("User Id:                      "+user.getUserId());
          System.out.println("User Name:                    "+user.getUserName());
          System.out.println("User Phone no:                "+user.getPhoneNo());
          System.out.println("User Email Id:                "+user.getEmailId());
          System.out.println("User Address:                 "+user.getAddress());
          System.out.println("User has MemberShip:          "+user.getHasMemberShip());

      }

    }
    public ManageUsers()
    {
         libraryDatabase =LibraryDatabase.getInstance();
         checkList=ManageUserController.getInstance();
    }
    private String dateFormat(long millis)
    {
        DateFormat dateFormat =new SimpleDateFormat("dd-MM-yy");
        return dateFormat.format(new Date(millis));
    }
}

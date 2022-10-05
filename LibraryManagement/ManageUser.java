package librarymanagement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageUser  extends UserList{

      ArrayList<UserList> userLists=new ArrayList<>();
    public ManageUser() {
        super();
    }

    private void assignBookToUser() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the user Id");
        int userId = scan.nextInt();
        if (!userIdCheck(userId)) {
            System.out.println("Cannot Identify user Id");
            return;
        }

        System.out.println("Enter the Book Id");
        int bookId = scan.nextInt();
        if (!bookIdCheck(bookId)) {
            System.out.println("Cannot Identify the book");
            return;
        }
        for (BookAssignDetails bookAssign : bookAssignDetails) {
            if (bookAssign.userId == userId) {
                if (bookId == bookAssign.bookId&&bookAssign.bookStatus==null) {
                    System.out.println("You already have that book");
                    return;
                }
            }
        }
        LocalDate localDate=java.time.LocalDate.now();
        int count = jdbcUpdate("insert into bookassignlist(bookid,userid,bookassigndate)"
                + " values(" + bookId + "," + userId + ",'" +localDate.toString()+ "')");
        bookAssignDetails.add(new BookAssignDetails(bookId,userId,localDate.toString(),"404",0,null));
        System.out.println("SuccessFully Assign");
    }
    private void returnTheBook()
    {
        Scanner scan=new Scanner(System.in);
        int userIdCheck = 1, bookIdCheck = 1;
        int userId=0;
        int bookId=0;
        int bookRate = 0;
        String status="";
        BookAssignDetails returnBookAdd = null;
        int fine=0;
        boolean bool=true;
       f1: while(bool) {

            System.out.println("Enter the user Id");
            userId = scan.nextInt();
            if (userId != userid.get(userId - userStart)) {
                System.out.println("Enter the correct user id");
                continue;
            }


            System.out.println("Enter the Book Id");
            bookId = scan.nextInt();

            for (BookAssignDetails bookAssign : bookAssignDetails) {
                if (bookAssign.userId == userId) {
                    userIdCheck = 0;
                    if (bookId == bookAssign.bookId&&bookAssign.bookStatus==null) {
                        bookIdCheck = 0;
                        bookRate=bookList.get(bookId-bookIdStart).bookrate;
                        returnBookAdd = bookAssign;
                        break f1;
                    }
                    else {
                        System.out.println("You already return that book");return;}
                }
            }
        }
            if(userIdCheck==1){
                System.out.println("The user Does not have any book");return;}
            if(bookIdCheck==1){
                System.out.println("The book id was Wrong ");return;}

            System.out.println("Enter the book status");
            System.out.println();
            System.out.println("Good         Press 1");
            System.out.println("Damage       Press 2");
            byte option=scan.nextByte();
            if(option==2){ fine=bookRate/2;status="damaged";}
            else{ fine=0; status="Good";}

            LocalDate localDate=java.time.LocalDate.now();

            int count=jdbcUpdate("update bookassignList set returndate ='"+localDate.toString()+"'," +
                    "damagefine="+fine+",bookstatus='"+status+"' where bookid="+bookId+" and  userid="+userId);
            returnBookAdd.bookReturnDate=localDate.toString();
            returnBookAdd.damageFine=fine;
            returnBookAdd.bookStatus=status;
            System.out.println("Book succesfully returned");


    }
    private void addUser()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the user Id");
        int Id=scan.nextInt();
        if(userIdCheck(Id)){ System.out.println("Cannot add ");return;}
        scan.nextLine();
        System.out.println("Enter the user name");
        String userName=scan.nextLine();
        System.out.println("Enter the user Mobile number");
        long mobileno=scan.nextLong();
        int count=jdbcUpdate("insert into libraryuser values("+(userid.size()+userStart)+",'"
                              + userName+"',"+mobileno+")");

        System.out.println("SucessFully added");
    }
     private void viewUser()
     {
         Scanner scan=new Scanner(System.in);
         System.out.println("Enter the user Id");
         int userId=scan.nextInt();
          try {


          if(userId!=userid.get(userId-userStart))
          { System.out.println("The Id is wrong"); return;}
          UserList user=userLists.get(userId-userStart);
         System.out.println("User ID:"+user.userId+" User Name:"+user.userName+" User phoneno:"+user.mobileno);
         }catch (Exception e){e.printStackTrace();}
     }
     private void viewUserList()
     {
         for(UserList user:userLists)
         {
             System.out.println("User ID:"+user.userId+"\tUser Name:"+user.userName+"\tUser phoneno:"+user.mobileno);
             System.out.println();
         }
     }
     private  void viewBookAssignList()
     {
         //for
     }
    public void manageUser()
    {
        Scanner scan=new Scanner(System.in);
        boolean bool=true;
        byte option=0;

        while(bool)
        {
            System.out.println("View User                   Press 1");
            System.out.println("Add User                    Press 2");
            System.out.println("View User List              Press 3");
            System.out.println("Assign Book User            Press 4");
            System.out.println("Return the book             Press 5");
            System.out.println("View the book Assign List   Press 6");
            System.out.println("Exit                        Press 7");
            System.out.println("Enter the option");
            option=scan.nextByte();
            if(option==7){bool=false;return;}
            switch (option)
            {
                case 1:viewUser();
                break;
                case 2:addUser();
                break;
                case 3:viewUserList();
                break;
                case 4:assignBookToUser();
                break;
                case 5:returnTheBook();
                break;
                case 6:viewBookAssignList();
                default:
                    System.out.println("Enter the valid one");

            }
        }
    }

}

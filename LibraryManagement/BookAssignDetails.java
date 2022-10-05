package librarymanagement;

import java.util.ArrayList;

public class BookAssignDetails extends LoginController {

    int bookId;
    int userId;
    String bookAssaignDate;
    String bookReturnDate;
    int damageFine;
    String bookStatus;
    ArrayList<BookAssignDetails>  bookAssignDetails=new ArrayList<>();
    public  BookAssignDetails(int bookId,int userId,String bookAssaignDate,String bookReturnDate
                               ,int damageFine,String bookStatus)
    {
        this.bookId=bookId;
        this.userId=userId;
        this.bookAssaignDate=bookAssaignDate;
        this.bookReturnDate=bookReturnDate;
        this.damageFine=damageFine;
        this.bookStatus=bookStatus;
    }
   public  BookAssignDetails() {super();}

}

//package controler;
//
//import model.Book;
//import model.BookTransactions;
//import model.LibraryDatabase;
//import model.User;
//
//import java.util.List;
//
//public class CheckList {
//    private LibraryDatabase libraryDatabase;
//    private static CheckList checkList=null;
//
//    public  CheckList()
//    {
//        libraryDatabase=LibraryDatabase.getInstance();
//    }
//    public  static CheckList getInstance()
//    {
//        if(checkList==null)checkList=new CheckList();
//        return checkList;
//    }
//    public boolean bookIdCheck(long bookId)
//    {
//        List<Book> bookList=libraryDatabase.getBookList();
//        for(Book book:bookList)
//        {
//            if(book.getId()==bookId)
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//    public BookTransactions bookTransactionCheck(long bookId, int userId)
//    {
//        List<BookTransactions> transactionsList=libraryDatabase.getBookTransaction();
//        for(BookTransactions bookTransactions:transactionsList)
//        {
//            if(bookId==bookTransactions.getBookId()&&userId==bookTransactions.getUserId())
//            {
//                if(!bookTransactions.isReturned())
//                {
//                    return bookTransactions;
//                }
//                System.out.println("The book is already returned");
//                return  null;
//            }
//        }
//        System.out.println("This don't have this Book");
//        return  null;
//    }
//    public Book getBookInstance(long bookId)
//    {
//        List<Book> bookList=libraryDatabase.getBookList();
//        for(Book bookTraverse:bookList)
//        {
//            if(bookTraverse.getId()==bookId)
//            {
//                return bookTraverse;
//            }
//        }
//        return null;
//    }
//    public boolean previousFineAmountCheck(int userId)
//    {
//        List<BookTransactions> bookTransactions=libraryDatabase.getBookTransaction();
//        for(BookTransactions bookTraverse:bookTransactions)
//        {
//            if(bookTraverse.getUserId()==userId)
//            {
//                if(!bookTraverse.isReturned()){
//                    System.out.println("You already have one book ");return true;}
//                if(bookTraverse.getFineAmount()>0&&!bookTraverse.isPaied())
//                {
//                    System.out.println("You already have fine");
//                    return true;
//                }
//
//            }
//        }
//        return  false;
//    }
//    public boolean userIdCheck(int userId)
//    {
//        List<User> userList=libraryDatabase.getUserList();
//        for(User user:userList)
//        {
//            if(user.getUserId()==userId)
//            {
//                return true;
//            }
//        }
//        return  false;
//    }
//    public boolean bookAvailabiltyCheck(Long bookId)
//    {
//
//        List<Book> bookList=libraryDatabase.getBookList();
//        for(Book book:bookList)
//        {
//            if(book.getId()==bookId)
//            {
//                return book.getAvailablity();
//            }
//        }
//        return false;
//    }
//}

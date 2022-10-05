package view;

import model.Book;
import model.LibraryDatabase;

import java.util.List;
import java.util.Scanner;

public class ManageBooks {

    Book bookAdd;
    int generateBookId=1001;
    LibraryDatabase libraryDatabase;
    Scanner scanner=new Scanner(System.in);
    public void bookInfo()
    {
        Scanner scanner=new Scanner(System.in);
        boolean bool=true;
        int option=0;
        while(bool)
        {
            System.out.println();
            System.out.println("Add Book               Press 1");
            System.out.println("Delete Book            Press 2");
            System.out.println("View Book List         Press 3");
            System.out.println("View Book Availablity  Press 4");
            System.out.println("Exit                   Press 5");
            System.out.println("Enter the option");
            option=scanner.nextInt();
            if(option==5){bool=false;return;}
            switch(option)
            {
                case 1:addBook();
                break;
                case 2:deleteBook();
                break;
                case 3:viewBookList();
                break;
                case 4:viewBookAvailablity();
                break;
                default:
                    System.out.println("Enter the valid one");

            }
        }
    }

    private void viewBookList()
    {
        List<Book> bookListView=libraryDatabase.getBookList();
        for(Book bookIterate:bookListView)
        {
            System.out.println("Book Id                :"+bookIterate.getId());
            System.out.println("Book Title             :"+bookIterate.getTitle());
            System.out.println("Book Auther            :"+bookIterate.getAuthor());
            System.out.println("Book Publications      :"+bookIterate.getPublication());
            System.out.println("Book Edition           :"+bookIterate.getEdition());
            System.out.println("Book Journer           :"+bookIterate.getJourner());
            System.out.println("Book Volume            :"+bookIterate.getVolume());
            System.out.println("Book Availablity       :"+bookIterate.getAvailablity());
            System.out.println();
        }
    }
    private void addBook()
    {
        Book book=new Book();
        System.out.println("Enter the book ID");
        long bookId=scanner.nextLong();
        System.out.println("Enter the  book title");
        scanner.nextLine();
        String bookTitle=scanner.nextLine();
        System.out.println("Auther name");
         String author=scanner.nextLine();
        System.out.println("Book Publication");
         String publication=scanner.nextLine();
        System.out.println("Book Edition");
         String edition=scanner.next();
        System.out.println("Book Journer");
         String journer=scanner.next();
        System.out.println("Book Volume");
         int volume=scanner.nextInt();
        System.out.println("Book Availablity");
         boolean availablity=scanner.nextBoolean();
        System.out.println("Your Book Id :"+generateBookId);
        book.setId(generateBookId++);
        book.setTitle(bookTitle);
        book.setAuthor(author);
        book.setPublication(publication);
        book.setEdition(edition);
        book.setJourner(journer);
        book.setVolume(volume);
        book.setAvailablity(availablity);
        libraryDatabase.insertBook(book);
        System.out.println(" book Success Full Added");
    }
    private void deleteBook()
    {
        System.out.println("Enter the Book Id");
        int bookId=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Book title");
        String bookTittle=scanner.nextLine();
        System.out.println("Enter the Book Auther");
        String bookAuther=scanner.nextLine();

        List<Book> bookList=libraryDatabase.getBookList();
        int count=0;
        for(Book book:bookList)
        {
            if(book.getId()==bookId&&book.getTitle().equals(bookTittle)&&book.getAuthor().equals(bookAuther))
            {
                bookList.remove(count);
                System.out.println("Book Removed");
                return;
            }
            count++;
        }
    }
    public ManageBooks()
    {
        bookAdd=new Book();
        libraryDatabase=LibraryDatabase.getInstance();
    }
    private void viewBookAvailablity()
    {
        System.out.println("Enter the Book ID");
        long bookId=scanner.nextLong();
        List<Book> bookList=libraryDatabase.getBookList();
        for(Book bookTraverse:bookList)
        {
            if(bookTraverse.getId()==bookId)
            {
                if(bookTraverse.getAvailablity()) {
                    System.out.println("The Book Is Available");
                }
                else System.out.println("The bool not available");
                return;

            }
        }
        System.out.println("Wrong Book ID");
    }

}


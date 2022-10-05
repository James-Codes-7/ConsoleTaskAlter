package model;

public class BookTransactions {
    private long bookId;
    private int userId;
    private long dateBorrowed;
    private long dateToBeReturn;
    private long returnedDate;
    private boolean isFined;
    private int fineAmount;
    private boolean isPaied;
    private long finedDate;
    private long fineDueDate;
    private long finePaidDate;
    private boolean isReturned;

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public long getBookId() {
        return bookId;
    }
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public long getDateToBeReturn() {
        return dateToBeReturn;
    }

    public long getFinePaidDate() {
        return finePaidDate;
    }

    public void setFinePaidDate(long finePaidDate) {
        this.finePaidDate = finePaidDate;
    }

    public long getFineDueDate() {
        return fineDueDate;
    }

    public void setFineDueDate(long fineDueDate) {
        this.fineDueDate = fineDueDate;
    }

    public long getFinedDate() {
        return finedDate;
    }

    public void setFinedDate(long finedDate) {
        this.finedDate = finedDate;
    }

    public boolean isPaied() {
        return isPaied;
    }

    public void setPaied(boolean paied) {
        isPaied = paied;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public boolean isFined() {
        return isFined;
    }

    public void setFined(boolean fined) {
        isFined = fined;
    }

    public long getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(long returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void setDateToBeReturn(long dateToBeReturn) {
        this.dateToBeReturn = dateToBeReturn;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(long dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }
}

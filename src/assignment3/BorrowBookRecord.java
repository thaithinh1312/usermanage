package assignment3;

import java.util.Date;
import java.util.ArrayList;

public class BorrowBookRecord 
{
    private String username;
    private String bookISBN;
    private int bookCopyNumber;
    private Date borrowDate;
    private String librarianUsernameBorrow;
    private Date returnDate = null;
    private boolean status = true;
    private String librarianUsernameReturn;

    public BorrowBookRecord(String username, String bookISBN, int bookCopyNumber, Date borrowDate, String librarianUsernameBorrow) 
    {
        this.username = username;
        this.bookISBN = bookISBN;
        this.bookCopyNumber = bookCopyNumber;
        this.borrowDate = borrowDate;
        this.librarianUsernameBorrow = librarianUsernameBorrow;
        this.returnDate = null;
        this.status = true;
        this.librarianUsernameReturn = "";
    }
    
    public boolean ReturnBook(Date returnDate, String librarianUsernameReturn)
    {
        this.returnDate = returnDate;
        this.librarianUsernameReturn = librarianUsernameReturn;
        this.status = false;
        return true;
    }
    
    
    public boolean isReturned()
    {
        if (this.status == false){
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean filterRecordByUsername(String username)
    {
        if (this.username.equals(username) && !isReturned())
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean filterRecordByUsername(String username, String bookISBN)
    {
        if (this.username.equals(username) && this.bookISBN.equals(bookISBN) && !isReturned())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean filterRecordByUsername(String username, String bookISBN, int bookCopyNumber)
    {
        if (this.username.equals(username) && this.bookISBN.equals(bookISBN) && this.bookCopyNumber == bookCopyNumber && !isReturned()){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean filterRecordByISBN(String bookISBN)
    {
        if (this.bookISBN.equals(bookISBN)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public static int checkNumberOfBorrowedBooksByUsername(ArrayList<BorrowBookRecord> books, String username)
    {
        int numberOfBooks = 0;
        for (BorrowBookRecord book : books)
        {
            if (book.filterRecordByUsername(username) && book.isReturned() == false)
            {
                numberOfBooks += 1;
            }
        }
        return numberOfBooks;
    }
    
    public static int checkNumberOfBorrowedBooksByISBN(ArrayList<BorrowBookRecord> books, String ISBN)
    {
        int numberOfBooks = 0;
        for (BorrowBookRecord book : books)
        {
            if (book.filterRecordByISBN(ISBN) && book.isReturned() == false){
                numberOfBooks += 1;
            }
        }
        return numberOfBooks;
    }
    
    public static boolean returnBorrowedBook(ArrayList<BorrowBookRecord> books, String username, String ISBN, int CopyNumber, String librarian)
    {
        boolean returnBook = false;
        for (BorrowBookRecord book : books)
        {
            if (book.filterRecordByUsername(username, ISBN, CopyNumber) == true)
            {
                book.status = false;
                book.returnDate = new Date();
                book.librarianUsernameReturn = librarian;
                returnBook = true;
            }
        }
        return returnBook;
    }

    @Override
    public String toString() {
        return "BorrowBookRecord{" + "username=" + username + ", bookISBN=" + bookISBN + ", bookCopyNumber=" + bookCopyNumber + ", borrowDate=" + borrowDate + ", librarianUsernameBorrow=" + librarianUsernameBorrow + ", returnDate=" + returnDate + ", status=" + status + ", librarianUsernameReturn=" + librarianUsernameReturn + '}';
    }
    
    
}


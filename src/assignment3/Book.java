package assignment3;

import java.util.ArrayList;
import java.util.Comparator;

enum Status {Available, Reserved, Borrowed, Damaged};

public class Book implements Cloneable, Comparable<Book>
{
    private String ISBNNumber;
    private int bookCopyNumber;
    private String title;
    private ArrayList<String> authorName;
    private String location;
    private String bookType;
    private Status bookStatus;
    private String createdOrModifiedByUsername;

    public Book(String ISBNNumber, int bookCopyNumber, String title, ArrayList<String> authorName, String location, String bookType, Status bookStatus, String createdOrModifiedByUsername) 
    {
        this.ISBNNumber = ISBNNumber;
        this.bookCopyNumber = bookCopyNumber;
        this.title = title;
        this.authorName = authorName;
        this.location = location;
        this.bookType = bookType;
        this.bookStatus = bookStatus;
        this.createdOrModifiedByUsername = createdOrModifiedByUsername;
    }

    public String getISBNNumber() 
    {
        return ISBNNumber;
    }

    public int getBookCopyNumber() {
        return bookCopyNumber;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) 
    {
        if (User.isStringOnlyAlphabet(title))
        {
            this.title = title;
        }
        else 
        {
            throw new IllegalArgumentException("Title cannot contain special character or number");
        }
    }
   

    public ArrayList<String> getAuthorName() 
    {
        return authorName;
    }

    protected void setAuthorName(ArrayList<String> authorName) 
    {
        for (String name : authorName)
        {
            if (!User.isStringOnlyAlphabet(name))
            {
                throw new IllegalArgumentException("Names cannot contain special character or number");
            }
        }
        this.authorName = authorName;
    }

    public String getLocation() 
    {
        return location;
    }
    
    protected void setLocation(String location) 
    {
        if (User.isStringOnlyAlphabet(location))
        {
            this.location = location;
        }
        else 
        {
            throw new IllegalArgumentException("Location cannot contain special character");
        }
    }


    public String getBookType() 
    {
        return bookType;
    }
    
    protected void setBookType(String bookType) 
    {
        if (User.isStringOnlyAlphabet(bookType))
        {
            this.bookType = bookType;
        }
        else 
        {
            throw new IllegalArgumentException("Book type cannot contain special character or number");
        }
    }

    public Status getBookStatus() 
    {
        return bookStatus;
    }
    
    public void setBookStatus(Status bookStatus) 
    {
        this.bookStatus = bookStatus;
    }

    public String getCreatedOrModifiedByUsername() 
    {
        return createdOrModifiedByUsername;
    }

    protected void setCreatedOrModifiedByUsername(String createdOrModifiedByUsername) 
    {
        if (User.isStringOnlyAlphabet(createdOrModifiedByUsername))
        {
            this.createdOrModifiedByUsername = createdOrModifiedByUsername;
        }
        else 
        {
            throw new IllegalArgumentException("createdOrModifiedByUsername cannot contain special character or number");
        }
    }
    
    public boolean isBorrowed()
    {
        if (this.bookStatus == bookStatus.Borrowed){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isReserved()
    {
        if (this.bookStatus == bookStatus.Reserved){
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isAvailable()
    {
        if (this.bookStatus == bookStatus.Available)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isDamaged()
    {
        if (this.bookStatus == bookStatus.Damaged)
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean checkBookInfoByISBNandCopy(String ISBN, int bookCopyNumber)
    {
        if (this.ISBNNumber == ISBN && this.bookCopyNumber == bookCopyNumber)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean updatedBorrowed(String username)
    {
        this.bookStatus = bookStatus.Borrowed;
        this.createdOrModifiedByUsername = username;
        return true;
    }
    
    public boolean updatedReserved(String username)
    {
        this.bookStatus = bookStatus.Reserved;
        this.createdOrModifiedByUsername = username;
        return true;
    }
    public boolean updatedAvailable(String username)
    {
        this.bookStatus = bookStatus.Available;
        this.createdOrModifiedByUsername = username;
        return true;
    }
    public boolean updatedDamaged(String username)
    {
        this.bookStatus = bookStatus.Damaged;
        this.createdOrModifiedByUsername = username;
        return true;
    }
    
    public void editBook(String title, ArrayList<String> authorName, String location, String bookType,String username, Status status) 
    {
        this.title = title;
        this.authorName = authorName;
        this.location = location;
        this.bookType = bookType;
        this.createdOrModifiedByUsername = username;
        this.bookStatus = status;
    }
    
    public static boolean stringContainsOnlyAlphabetAndNumber(String str)
    {
        return ((!str.equals("")) && (str != null) && (str.matches("[^A-Za-z0-9]")));
    }

    @Override
    public Book clone() throws CloneNotSupportedException
    {
        return (Book)super.clone();
    }
    
    @Override
    public int compareTo(Book book)
    {
        int i = ISBNNumber.compareTo(book.ISBNNumber);
        if(i!=0) return i;
        return Integer.compare(bookCopyNumber,book.bookCopyNumber);
    }
    
    public static Book findBookByISBNAndCopyNumber(ArrayList<Book> books, String ISBNNumber, int bookCopyNumber)
    {
        for (Book book : books){
            if (book.ISBNNumber.equals(ISBNNumber) && book.bookCopyNumber == bookCopyNumber)
            {
                return book;
            }
        }
        return null;
    }
    
    public static ArrayList<Book> findBookByISBN(ArrayList<Book> books, String ISBNNumber)
    {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books)
        {
            if(book.ISBNNumber.equals(ISBNNumber)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public static ArrayList<Book> findBookByStatus(ArrayList<Book> books, Status status)
    {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books)
        {
            if(book.bookStatus == status){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
    
    public static ArrayList<String> allBookTitleToArrayListOfString(ArrayList<Book> books)
    {
        ArrayList<String> titles = new ArrayList<>();
        for (Book book : books)
        {
            if(!titles.contains(book.title))
            {
                titles.add(book.title);
            }
        }
        return titles;
    }
    
    public static String allBookToString(ArrayList<Book> books)
    {
        String allBooks = "";
        for (Book book : books)
        {
            allBooks += book.toString();
        }
        return allBooks;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s %s %s %s %s %n",ISBNNumber, bookCopyNumber, title, authorName, location, bookType, bookStatus, createdOrModifiedByUsername);
    }
    
}
 
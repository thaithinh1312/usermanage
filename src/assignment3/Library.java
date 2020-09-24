package assignment3;

import java.util.ArrayList;
import java.util.Date;

public class Library 
{
    private ArrayList<User> users = null;
    private ArrayList<Book> books = null;
    private ArrayList<BorrowBookRecord> borrowrecords = null;
    
    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
        borrowrecords = new ArrayList<>();
    }
    
    public ArrayList<User> getUsers()
    {
        return users;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public ArrayList<BorrowBookRecord> getBorrowedBooks() {
        return borrowrecords;
    }
    
    public boolean verifyLogIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        System.out.println("Incorrect username or password");
        return false;
    }
    
    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }
    
    public boolean addBorrowedBook(BorrowBookRecord book){
        borrowrecords.add(book);
        return true;
    }
    
    public boolean addUser(User user) {
        for (User u : users) {
            if (user.getId().equals(u.getId())) {
                return false;
            }
        }
        users.add(user);
        System.out.println(user.getUsername() + " has been added successfully");
        return true;
    }
    
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                System.out.println(user.getUsername() + "'s password has been changed");
                return true;
            }
        }
        System.out.println("Incorrect username or password");
        return false;
    }
    
    public String getUsernameByUserFullName(String firstName, String lastName) {
        for (User user : users) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                return user.getUsername();
            }
        }
        throw new IllegalArgumentException("User not found");
    }
    
    public String getUserInfoByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.toString();
            }
        }
        System.out.println("User not found");
        return null;
    }    

    public String getUserFullNameByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getFullName();
            }
        }
        System.out.println("User not found");
        return null;
    }
    
    public ArrayList<String> getListOfUserfullName() {
        ArrayList<String> nameList = new ArrayList<>();
        for (User user : users) {
            nameList.add(user.getFullName());
        }
        return nameList;
    }
    
    public boolean editBook(String username, Book editedBook) 
    {
        boolean missionCompletes = false;
        for (Book book : books) 
        {
            if (book.getISBNNumber().equals(editedBook.getISBNNumber())) 
            {
                book.editBook(editedBook.getTitle(), editedBook.getAuthorName(), editedBook.getLocation(), editedBook.getBookType(), username,editedBook.getBookStatus());
                missionCompletes = true;
            }
        }
        if (missionCompletes == true)
        {
            return missionCompletes;
        }
        else
        {
            throw new IllegalArgumentException("Cannot find book that matches");
        }
    }
    
    public ArrayList<String> listAllBookTitle() {
        ArrayList<String> allBookTitle = new ArrayList<>();
        for (Book book : books) {
            allBookTitle.add(book.getTitle());
        }
        return allBookTitle;
    }
    
    public ArrayList<Book> findBookByISBN(String ISBN) {
        return Book.findBookByISBN(this.books, ISBN);
    }
    
    public boolean addBorrowBookRecord(String librarianUserName, String studentUserName, String bookISBN, int bookCopyNumber) {
        
        BorrowBookRecord book = new BorrowBookRecord(studentUserName, bookISBN, bookCopyNumber, new Date(), librarianUserName);
        this.borrowrecords.add(book);
        return true;
    }
    
    public boolean returnBookRecord(String librarianUsername, String studentUserName, String bookISBN, int bookCopyNumber) 
    {
        Book.findBookByISBNAndCopyNumber(books, bookISBN, bookCopyNumber).updatedAvailable(librarianUsername);
        return BorrowBookRecord.returnBorrowedBook(borrowrecords, studentUserName, bookISBN, bookCopyNumber, librarianUsername);
    }
    
    public boolean isUserLibrarian(String username) {        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getUserType() == UserType.Librarian) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isUserAdmin(String username) 
    {        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getUserType() == UserType.Admin) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isUserStaff(String username) 
    {        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user instanceof Staff) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isUser(String username) 
    {        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getUserType() == UserType.Admin) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void printBookInfo() 
    {
        for (Book book : books) 
        {
            System.out.printf("%-20s %-4s %-4d %n", book.getTitle(), book.getISBNNumber(), book.getBookCopyNumber());
        }
    }
    
    public User getUser(String username) 
    {
        if (User.findUserByUsername(users, username) != null) 
        {
            return User.findUserByUsername(users, username);
        } 
        else 
        {
            return null;
        }
    }
    
    public Book getBook(String ISBN, int copyNumber) 
    {
        if (Book.findBookByISBNAndCopyNumber(books, ISBN, copyNumber) != null) 
        {
            return Book.findBookByISBNAndCopyNumber(books, ISBN, copyNumber);
        } 
        else 
        {
            return null;
        }
    }
    
    
    public boolean checkBorrowRight(String username)
    {
        PermissionType permission = User.findUserByUsername(users, username).getPermission();
        if ( permission == PermissionType.Borrow || permission == PermissionType.BorrowAndEdit)
        {
            return true;
        }
        else{
            
            return false;
        }
    }
    
    public boolean checkExceedNumberAllowed(String username)
    {
        int num = BorrowBookRecord.checkNumberOfBorrowedBooksByUsername(borrowrecords, username);
        int limit = User.findUserByUsername(users, username).getUserType().getNumberOfAllowedBooksToBorrow();
        if(num < limit)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean checkBorrowRecord(String username, String bookISBN)
    {
        boolean found = false;
        for (BorrowBookRecord b : borrowrecords)
        {
            if (b.filterRecordByUsername(username, bookISBN) == true)
            {
                found = true;
            }
        }
        return found;
    }
    
    public ArrayList<User> findUsersByLastName(String lastName)
    {
        ArrayList<User> list = new ArrayList<User>();
        for (User user : users)
        {
            if (user.getLastName().equals(lastName))
            {
                list.add(user);
            }
        }
        return list;
    }
    
    public ArrayList<User> findUsersByFirstName(String firstName)
    {
        ArrayList<User> list = new ArrayList<User>();
        for (User user : users)
        {
            if (user.getFirstName().equals(firstName))
            {
                list.add(user);
            }
        }
        return list;
    }
    
    public ArrayList<User> findActiveUsers()
    {
        ArrayList<User> list = new ArrayList<User>();
        for (User user : users)
        {
            if (user.getStatus() == true)
            {
                list.add(user);
            }
        }
        return list;
    }
    
    public User findUsersById(String id)
    {
        User userFound = null;
        for (User user : users)
        {
            if (user.getId().equals(id))
            {
                userFound = user;
            }
        }
        return userFound;
    }
}

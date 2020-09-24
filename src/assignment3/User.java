package assignment3;

import java.util.ArrayList;

public abstract class User implements Cloneable, Comparable<User>, BorrowInfo
{
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserType userType;
    private PermissionType permission;
    private boolean status;
    private Address address;
    
    public User(String id, String firstName, String lastName, String username, String password, UserType userType, PermissionType permission, boolean status, Address address) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
        this.status = status;
        this.address = address;
    }
    public boolean getStatus()
    {
        return this.status;
    }
    public void setStatus(Boolean hihi)
    {
        this.status = hihi;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    public String getId()
    {
        return id;
    }
    protected void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    protected String getPassword(){
        return password;
    }
    
    public void setPassword(String password) 
    {
        if (password.length()<5 || password.length() > 20)
        {
            throw new IllegalArgumentException ("Password should be in range of 5 - 20");
        }
        else
        {
            this.password = password;            
        }
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if (isStringOnlyAlphabet(firstName)){
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Name cannot contain special character");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        if (isStringOnlyAlphabet(lastName)){
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Name cannot contain special character");
        }
    }
    
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public PermissionType getPermission() {
        return permission;
    }

    public void setPermission(PermissionType permission) {
        this.permission = permission;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public boolean verifyUsernameAndPassword(String userName, String password)
    {
        if (userName.equals(this.username)&&password.equals(this.password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean verifyUsername(String username)
    {
        if (username.equals(this.username))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean verifyUserType(UserType userType)
    {
        if (this.userType == userType)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean verifyPermission(PermissionType permission)
    {
        if (permission == this.permission)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", id, firstName, lastName, username,password, userType.name(), permission.name(), status);
    }
    
    @Override
    public User clone() throws CloneNotSupportedException
    {
        return (User) super.clone();
    }
    
    @Override
    public int compareTo(User user)
    {
        return this.lastName.compareTo(user.lastName);
    }
    
    public static User findUserByUsername (ArrayList<User> users, String name)
    {
        User user = null;
        for (User u : users)
        {
            if (u.username.equals(name))
            {
                user = u;
                return u;
            }
        }
        return user;
    }
    
    public static boolean verifyLogInByUsernameAndPassword(ArrayList<User> users, String username, String password)
    {
        for (User user : users)
        {
            if (user.username.equals(username) && user.password.equals(password)){
                return true;
            }
        }
        System.out.println("Incorrect username or password");
        return false;
    }
    
    public static ArrayList<String> getListOfUserFullName(ArrayList<User> users)
    {
        ArrayList<String> nameList = null;
        for (User user : users)
        {
            nameList.add(user.getFullName());
        }
        return nameList;
    }
    
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
    }
    
    @Override 
    public int getMaxNumberOfAllowedBook()
    {
        return this.userType.getNumberOfAllowedBooksToBorrow();
    }
    
}

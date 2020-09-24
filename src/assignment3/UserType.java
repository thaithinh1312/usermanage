package assignment3;

enum UserType
{
    Student("Under Graduate Student",1,20),
    PostStudent("Post Graduate Student",2,30),
    AdminStaff("Administrative staff",3,30),
    Librarian("Librarian",4,40),
    AcademicStaff("Academic Staff",5,40),
    Admin("System Administrator",6,30);
    
    private String name;
    private int id;
    private int numberOfAllowedBooksToBorrow;

    UserType(String name, int id, int numberOfAllowedBooksToBorrow)
    {
        this.name = name;
        this.id = id;
        this.numberOfAllowedBooksToBorrow = numberOfAllowedBooksToBorrow;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public int getNumberOfAllowedBooksToBorrow()
    {
        return this.numberOfAllowedBooksToBorrow;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s ID: %d Number: %d", name, id, numberOfAllowedBooksToBorrow);
    }
    
}
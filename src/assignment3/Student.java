package assignment3;

public class Student extends User
{
    private String course;
    private String degree;

    public Student(String id, String firstName, String lastName, String username, String password, UserType userType,PermissionType permission, boolean status,String course, String degree, Address address) {
        super(id, firstName, lastName, username, password, userType, PermissionType.Reserve, status,address);
        if (Integer.parseInt(id)/1000000!=5)
        {
            throw new IllegalArgumentException("ID has to start with 5");
        }
        else
        {
            this.course = course;
            this.degree = degree;
        }
        
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) 
    {
        if (isStringOnlyAlphabet(course))
        {
            this.course = course;            
        }
        else
        {
            throw new IllegalArgumentException("Course name cannot contain special character");
        }
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) 
    {
        if (isStringOnlyAlphabet(degree))
        {
            this.degree = degree;            
        }
        else
        {
            throw new IllegalArgumentException("Degree name cannot contain special character");
        }
    }
    
    @Override
    public String getFirstName()
    {
        return super.getFirstName();
    }
    
    @Override
    public void setFirstName(String firstName)
    {
        super.setFirstName(firstName);
    }

    @Override
    public void setPermission(PermissionType permission)
    {
        if(permission == PermissionType.Reserve || permission == null)
        {
            super.setPermission(permission);
        }
        else
        {
            throw new IllegalArgumentException("Students are allowed to reserve only");
        }
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "," + String.format("%s,%s", course, degree);
    }
     

}

package assignment3;

enum Position {ADMIN, LIBRARIAN, GENERAL_OFFICE_STAFF, MANAGER, ACADEMIC_STAFF, TEACHING_ASSISTANT};
enum Department {BUSINESS, SOCIAL_SCIENCES, ARTS, LAW_HUMANITIES, EDUCATION, COMPUTING_IT};
        
public class Staff extends User
{
    private Position position;
    private double salary;
    private Department department;

    public Staff(String id, String firstName, String lastName, String username, String password, UserType userType, PermissionType permission, boolean status, Position position, double salary, Department department, Address address) 
    {
        super(id, firstName, lastName, username, password, userType, permission, status,address);
        if (position == Position.LIBRARIAN)
        {
            if (Integer.parseInt(id)/1000000!=4)
            {
                throw new IllegalArgumentException("ID must start with 4");
            }
        }
        else
        {
            if (Integer.parseInt(id)/1000000!=3)
            {
                throw new IllegalArgumentException("ID must start with 3");
            }
        }

        this.position = position;
        this.salary = salary;
        this.department = department;
        if (position != Position.LIBRARIAN)
        {
            System.out.println(super.getUsername() + "'s permission has been set to Reserve");
            super.setPermission(PermissionType.Reserve);
        }
    }
    
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) 
    {
        if (position != Position.LIBRARIAN)
        {
            this.position = position;
        }
        else 
        {
            throw new IllegalArgumentException("Position cannot be LIBRARIAN");
        }
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) 
    {
        if (salary > 0)
        {
            this.salary = salary;   
        }
        else
        {
            throw new IllegalArgumentException("Salary has to be larger than 0");
        }
    }

    public Department getDepartment() {
        return department;
    }
   
    public void setDepartment(Department department) 
    {
        if (this.position != Position.LIBRARIAN)
        {
            this.department = department;
        }
        else
        {
            throw new IllegalArgumentException("A librarian cannot have Department attribute");
        }
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "," + String.format("%s,%.0f,%s", position.name(), salary, department.name());
    }
}

package assignment3;

enum PermissionType {
    BorrowAndEdit("Allowed to borrow or edit",1), 
    Borrow("Only allowed to borrow",2), 
    Reserve("Only allowed to reserve",3),
    Edit("Allowed to edit only",4),
    None("Don't have any permission",5);
    
    private String name;
    private int id;
    
    PermissionType(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s ID: %d", name, id);
    }
};

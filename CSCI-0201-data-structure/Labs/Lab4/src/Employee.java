// CS 201 Employee class

public class Employee {
    private String name;
    private String department;
    private int ID;
    
    // Constructor initializes all instance variables
    public Employee(String name, String department, int ID) {
        this.name = name;
        this.department = department;
        this.ID = ID;
    }
    
    // Accessor methods
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getID() {
        return ID;
    }
    
    // toString method returns text representation of object
    public String toString() {
        return "Name: "   + getName() +
        ",\tDepartment: " + getDepartment() +
        ",\tID: " + getID();        
    }
}

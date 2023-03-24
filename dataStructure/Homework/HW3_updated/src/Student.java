// Student class for Homework 3
// Name: Xianzhi Wang  
import java.util.*;

public class Student extends Person {
    private String major;
    private String username;
    ArrayList<Grade> studentGrade; 
    
    // Default constructor
    public Student() {
        major = null;
        username = null;
    }
    
    // Constructor to initialize all instance variables of Person and Student
    public Student(String first, String last, int age, String major, String username) {
        super(first, last, age);  // Has to be first line in subclass constructor
        // if you don't call the super constructor, Java will implicitly call super()
        // so the superclass needs a default constructor
        this.major = major;
        this.username = username;
        studentGrade = new ArrayList<Grade>();
        
    }
    
    // Returns a string that includes name and major
    public String getNameAndMajor() {
        // No need to qualify firstName or lastName as they are inherited from Person
        // i.e., since there isn't a firstName or lastName field in Student, Java goes
        // up the inheritance chain to find one
        
        return firstName + " " + lastName + " " + major;
    }
    
    // Returns a string representation of Student
    public String toString() {
        return super.toString() + " " + username + " " + major + " " + gradesString();
    }
    
       public String getUsername(){
        return this.username;
       }
       public String getMajor(){
        return this.major;
       }
       public ArrayList<Grade> getGrades(){
        return studentGrade;
       }
       public String gradesString(){
        String foobar = "";
        for (int i = 0; i < studentGrade.size() - 1; i++){
            foobar += studentGrade.get(i).toString() + ", ";
        }
        if ( !(foobar.length() == 0) ) {
        foobar += studentGrade.get(studentGrade.size()-1);
        }
        return foobar;
       }
       public void addGrade(Grade grade){
        studentGrade.add(grade);

       }
       
       public void changeGrade(String assignment, int newScore){
        boolean flip = true;
        for ( int i = 0; i < studentGrade.size(); i++) {
            if (studentGrade.get(i).getName().equals(assignment)) {
               studentGrade.get(i).changeGrade(newScore); 
               flip = false;
            } 
        }
        if (flip) {
               System.out.println("The username cannot be found!");
            }
       }
    
    // Testing the Student class
    public static void main(String[] args) {
        Student student = new Student("Grace","Hopper",20,"CSCI","ghopper");
        System.out.println(student);
        System.out.println(student.getNameAndMajor());
        
    }
}

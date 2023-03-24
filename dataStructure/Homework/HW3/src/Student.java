import java.util.ArrayList;

// Student class for Homework 3
// Name: Xianzhi Wang 


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

        // studentGrade.add(null);
        
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
        // Have to qualify toString() call below, otherwise infinite recursion
        return super.toString() + " " + username + " " + major + " " + gradesString();  
    }
    
    // TODO: add additional method definitions 
    // including addGrade and any other instance or helper
    // methods needed to access and change a Student
    



    public String getUsername(){
        return username;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<Grade> getGrades() {
        return studentGrade; 
    }

    public String gradesString() {
        // String foobar = "";
        // for (Grade yourGrade : studentGrade ){
        //     foobar += yourGrade.toString() + ", ";
        // }
        // foobar = foobar.substring(0, foobar.length()-2);
        // return foobar;
        String foobar = "";
        for (int i = 0; i < studentGrade.size() - 1; i++){
            foobar += studentGrade.get(i).toString() + ", ";
        }
        if ( !(foobar.length() == 0) ) {
        foobar += studentGrade.get(studentGrade.size()-1);
        }
        return foobar;
    }

    public void addGrade(Grade grade) {
        studentGrade.add(grade);
    }

    public void changeGrade(String assignment, int newScore){

            for ( int i = 0; i < studentGrade.size(); i++) {
         if ( this.username.equals(username) ){

            studentGrade.get(i).changeGrade(newScore); 
            } 
        else {
            System.out.println("The username cannot be found!");
            }

        }

    }



    
    // Testing the Student class
    public static void main(String[] args) {
        Student student = new Student("Grace","Hopper",20,"CSCI","ghopper");
        System.out.println(student);
        System.out.println(student.getNameAndMajor());
        Grade goodGrade = new Grade("HW", 100);
        student.addGrade(goodGrade);
        System.out.println(student);
        // Create a new Student, add a Grade, and print out the student
    }
}

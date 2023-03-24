// Grade class for Homework 3
// Name: Xianzhi Wang 
public class Grade{
    private String name;
    private int score;
    // private ArrayList<Grade> grades;
    //constructor
public Grade(String name, int score) {
    this.name = name;
    this.score = score;
    // this.grades = new ArrayList<Grade>();


    
}

// instance methods get a grade name 
public String getName() {
    return this.name; 

}

// instance methods get a grade value
public int getScore() {
    return this.score;
}


public String toString() {
    return name + " " + score;
}


// instance method to change a grade value
public void changeGrade(int score) {
    this.score = score;
}







}
















// Grade class for Homework 3
// Name: Xianzhi Wang 


public class Grade {
    
    private String name;
    private int score;
    //constructor
public Grade(String name, int score) {
    this.name = name;
    this.score = score;


    
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
public void changeGrade(int newScore) {
    this.score = newScore;
}


    
    
}

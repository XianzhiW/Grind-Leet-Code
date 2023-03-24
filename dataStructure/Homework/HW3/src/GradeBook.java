// GradeBook class for Homework 3
// Name: Xianzhi Wang 

import java.util.*;
import java.io.*;

import javax.swing.RootPaneContainer;


public class GradeBook {
    
    private ArrayList<Student> roster;
    
    // Default constructor
    public GradeBook() {

        roster = new ArrayList<Student>();
    }
    
    // Constructor fills roster with data from file
    public GradeBook(String fileName) {
        roster = new ArrayList<Student>();
        // String myFile;
        // // for (int i = 0; i < 1; i++){
        //     myFile = getFileScanner(fileName).nextLine();
        //     System.out.println(myFile);
        //     Student myStudent = new Student();
        //     roster.add(myStudent);
        //     System.out.println(roster);

        //     // roster.add();
        // // }
        Scanner s = getFileScanner(fileName);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(" ");
            Student employee = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);

            for (int i = 5; i < data.length; i+=2) {
            Grade newGrade = new Grade(data[i], Integer.parseInt(data[i+1]));

            employee.addGrade(newGrade);
            // roster.add(employee);
            }

            roster.add(employee);
        }
        // while (s.)
        //     roster.get(0).addGrade(null);
        s.close();

    }
    
    // String representation of GradeBook
    public String toString() {
        // Loop through roster and print each student on its own line
        String gradeBookString = "";
        for (Student myItem : roster) {
            gradeBookString += myItem.toString() + "\n";
        }
        return gradeBookString; 
    }
    
    public void printIndividualGrades(String username) {
        // Student theirStudent = new Student();
        // roster.get(username);

        for ( int i = 0; i < roster.size(); i++) {
            if ( roster.get(i).getUsername().equals(username) ){
                System.out.println(roster.get(i).gradesString());
               } 
           else {
               System.out.println("");
               }
   
           }

    }
    public void printGradesByMajor(String major) {
        for (int i = 0; i < roster.size(); i++){
            if (roster.get(i).getMajor().equals(major)) {
                System.out.println(roster.get(i).gradesString());

            }
            else {
                System.out.println("");
            }
        }

    }

    public void removeStudent(String username) {
        for (int i = 0; i < roster.size(); i++){
        if (roster.get(i).getUsername().equals(username)) {
            roster.remove(i);
        }
        else{
            System.out.println("Username is not found!");
        }
    }

    }
    public void changeGrade(String username, String assignment, int newScore) {
        for (int i = 0; i < roster.size(); i++){
        if (roster.get(i).getUsername().equals(username)) {
            roster.get(i).changeGrade(assignment, newScore);
        }
        else{
            System.out.println("Username is not found!");
        }
    }


    }
    
    // Helper method to open a file for reading
    public static Scanner getFileScanner(String filename) {
        Scanner myFile;
        try { myFile = new Scanner(new FileReader(filename)); }
        catch (Exception e) {
            System.out.println("File not found: " + filename);
            return null;
        }
        return myFile;
    }
    
    // Helper method to open a file for writing
    public static PrintWriter getFileWriter(String filename) {
        PrintWriter outFile;
        try { outFile = new PrintWriter(filename); }
        catch (Exception e) {
            System.out.println("Error opening file: " + filename);
            return null;
        }
        return outFile;
    }

    public void printLetterGrade(String username) {

    }

    public void updateDatabase(String filename) {

    }

    public double whatDoINeed(String username, char target){
        double foo = 10;
        return foo; 
    }






    
    // Testing the GradeBook class
    public static void main(String[] args) {
        GradeBook grades = new GradeBook("data/S23grades.txt");
        System.out.println(grades);
        // TODO: add method calls here to test your code
        // System.out.println(grades.roster);
        // System.out.println(grades.changeGrade(null, null, 0););
        // System.out.println("***\n***");
        grades.printIndividualGrades("pahmad");
        // System.out.println("***\n***");
        grades.printGradesByMajor("CSCI");
    }
    
}

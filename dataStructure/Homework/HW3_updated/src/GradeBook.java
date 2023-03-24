// GradeBook class for Homework 3
// Name: Xianzhi Wang  

import java.util.*;
import java.io.*;

public class GradeBook {
    
    private ArrayList<Student> roster;
    
    // Default constructor
    public GradeBook() {
        roster = new ArrayList<Student>();
    }
    
    // Constructor fills roster with data from file
    public GradeBook(String fileName) {
        roster = new ArrayList<Student>();
        Scanner s = getFileScanner(fileName);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(" ");
            Student employee = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);

            for (int i = 5; i < data.length; i+=2) {
            Grade newGrade = new Grade(data[i], Integer.parseInt(data[i+1]));

            employee.addGrade(newGrade);
            }

            roster.add(employee);
        }
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
            boolean flip = true;
            for ( int i = 0; i < roster.size(); i++) {
                if ( roster.get(i).getUsername().equals(username) ){
                    System.out.println(roster.get(i).gradesString());
                    flip = false;
                   } 
               }
               if (flip) {
                   System.out.println("");
               }
        }
        public void printGradesByMajor(String major) {
            boolean flip = true;
            for (int i = 0; i < roster.size(); i++){
                if (roster.get(i).getMajor().equals(major)) {
                    System.out.println(roster.get(i).gradesString());
                    flip = false;
                }
            }
            if (flip) {
                System.out.println("");
            }
        }
        public void removeStudent(String username) {
            boolean flip = true;
            for (int i = 0; i < roster.size(); i++){
                if (roster.get(i).getUsername().equals(username)) {
                    roster.remove(i);
                    flip = false;
                }
            }
            if (flip){
            System.out.println("The username cannot be found!");
            }
        }

        public void changeGrade(String username, String assignment, int newScore) {
            boolean flip = true;
            for (Student myItem : roster){
                if (myItem.getUsername().equals(username)) {
                    myItem.changeGrade(assignment, newScore);
                    flip = false;
                }
            }
            if (flip) {
                System.out.println("The username cannot be found!");
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
    
    // Testing the GradeBook class
    public static void main(String[] args) {
        GradeBook grades = new GradeBook("data/S23grades.txt");
        System.out.println(grades);
        System.out.println("***");
        grades.changeGrade("atkachuk", "EXAM", 95);
        System.out.println("***");
        grades.changeGrade("atkachuk", "MIDTERM", 95);
        System.out.println("***");
    }
    
}







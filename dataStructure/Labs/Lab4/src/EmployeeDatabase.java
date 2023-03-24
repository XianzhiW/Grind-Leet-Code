// CS 201 Lab 4 - EmployeeDatabase
// Name: Xianzhi Wang  

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.time.chrono.ThaiBuddhistChronology;

public class EmployeeDatabase {
    
    private ArrayList<Employee> employees;
    
    // Default constructor
    public EmployeeDatabase() {
        employees = new ArrayList<Employee>(); 
    }
    
    // Constructor fills employee list with data from file
    public EmployeeDatabase(String filename) {
        employees = new ArrayList<Employee>();
        readEmployeeFile(filename);
    }
    
    // Reads data from file and adds to employees
    public void readEmployeeFile(String filename) {
        Scanner s = getFileScanner(filename);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(" ");
            Employee employee = new Employee(data[0], data[1], Integer.parseInt(data[2]));
            employees.add(employee);
        }
        s.close();
    }
    
    // Accessor method to return employees instance variable
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    
    // Adds an Employee to employees
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    // Merges two EmployeeDatabase lists based on in-order IDs
    public EmployeeDatabase merge(EmployeeDatabase other) {
        // this and other are already in-order by IDs
        EmployeeDatabase result = new EmployeeDatabase();
        int counter = 0;
        if (this.employees.size()==0) {
            result.employees = other.employees;
        }
        else if (other.employees.size()==0) {
            result.employees = this.employees;
        }
        else {
            for (int i = 0; i < this.employees.size(); i++){
                
                for (int j = counter; j < other.employees.size(); j++){
                    if (other.employees.get(j).getID()<this.employees.get(i).getID()){
                        result.addEmployee(other.employees.get(j));
                        counter = j+1;
                    }
                }
                result.addEmployee(this.employees.get(i));
            }
            int k = counter;
            while (k < other.employees.size()){
                result.addEmployee(other.employees.get(k));
                k++;
            }
        }
        return result;
    }
    
    // Returns a String representation of EmployeeDatabase object
    public String toString() {
        String result = "\n";
        for (int i = 0; i < employees.size(); i++) {
            result += i + ") " + employees.get(i) + "\n";
        }
        return result.substring(0,result.length()-1);
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
    
    public static void main(String[] args) {
        EmployeeDatabase list1 = new EmployeeDatabase("data/employees1.txt");
        EmployeeDatabase list2 = new EmployeeDatabase("data/employees2.txt");
        System.out.println(list1);
        System.out.println(list2);
        EmployeeDatabase merged = list1.merge(list2);
        EmployeeDatabase reversemerged = list2.merge(list1);
        System.out.println(merged);        
        System.out.println(reversemerged);        
    }
    
}




        
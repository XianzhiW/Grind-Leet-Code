// CS 201 Homework 4 - Tape
// Name: Xianzhi Wang  

import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

public class Tape {
    
    // Instance variables
    protected char current;
    protected ArrayList<Character> left;
    protected ArrayList<Character> right;
    
    // Constructor initializes instance variables
    public Tape() {
        left = new ArrayList<Character>();
        right = new ArrayList<Character>();
        current = '*';
    }
    
    /**
     * Method for storing the char c on the tape in the cell that's currently under the tape head
     * @param c
     */
    public void store(char c) {
        current = c;
    }
    /**
     * Method for moving the tape head one cell to the left
     */ 
    public void left() {
        right.add(current);

        if (left.size() == 0){
            left.add('*');
        }

        if (left.size()> 0){
            current = left.get(left.size()-1);
            left.remove(left.size()-1);
        }
        
    }
    /**
     * Method for moving the tape head one cell to the right 
     */ 
    public void right() {
        left.add(current);
        if (right.size()==0) {
            right.add('*');

        }
        
        if (right.size() > 0){
            current = right.get(right.size()-1);
            right.remove(right.size()-1);
        }
        
    }
    
    /**
     * Method that display (print) the contents of all cells in this tape ever visited by the tape head.
     */
    public void display() {
        if (left.size()>0){
            for (int i = 0; i < left.size(); i++){
            System.out.print(left.get(i)+" ");
            }

        }

        System.out.print("[" + current + "] ");

        if (right.size()>0){
            for (int j = right.size()-1; j >= 0; j--){
            System.out.print(right.get(j)+" ");
            }
        }
        
        System.out.println();

    }

    /**
     * Method that allows any sequence of tape operations to be specified by a sequence of characters stored in a string. 
     * @param input
     */
    public void processInput(String input) {
        // process characters of input one-by-one with switch statement
        for (int i = 0; i < input.length(); i++){
            char key = input.charAt(i);
            switch (key) {
                case '<': this.left();
                    break;
            
                case '>': this.right();
                    break;

                case '?': this.display();
                    break;

                default: this.store(key);
                    break;
            }
            
        }     
    }

    




    // main can be modified for testing
    public static void main (String[] args) {
        Tape t = new Tape();
        t.display();    // show current tape contents (empty tape)
        t.store('a');
        t.left();
        t.left();
        t.right();
        t.store('c');
        t.display();    // show current tape contents
        t.right();
        t.right();
        t.store('t');
        t.display();    // show current tape contents

    
} 

}


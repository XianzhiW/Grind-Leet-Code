import java.util.HashMap;

import javax.print.DocFlavor.INPUT_STREAM;

/**
* A partial singly-linked list implementation
* CSCI 201 Homework 5
*
* @author Xianzhi Wang 
* @param <E>
*/

public class SinglyLinkedList<E> extends LinkedList<E> {
    
    // TODO: write a Javadoc comment 
    public int getCount() {
        Node finger = head;
        int count = 0;
        while ( finger != null ) {
            count++;
            finger = finger.next();

        }
        return count;
    }
    
    // TODO: replace this line with a Javadoc comment
    public boolean containsDuplicates() {
        Node finger = head;
        boolean flip = false;

        if (head != null){
            HashMap<E, Integer> seeBefore = new HashMap<E, Integer>();
            while (finger != null ){ 
                // initialize the HashMap seeBefore 
                seeBefore.putIfAbsent(finger.value(), 0);
                finger = finger.next();
            }

            finger = head;
            while (finger != null) { 
                // check if we see it before
                seeBefore.put(finger.value(), seeBefore.get(finger.value())+1);
                finger = finger.next();
            }

            for (HashMap.Entry<E, Integer> set : seeBefore.entrySet()){
                if (set.getValue() >= 2) {
                    flip = true;
                }

            }
        }
        return flip;
    }
    
    // TODO: replace this line with a Javadoc comment
    // need double check
    public boolean remove(E value) {
        // TODO: fill this in and replace the placeholder line below
        boolean flip = false;
        if ( head != null ) {
            if (head.value().equals(value)) {
                head = head.next();
                flip = true;
            }
            else {
                Node finger = head.next();
                Node prev = head;

                while (finger != null && !finger.value().equals(value)) {
                    prev = finger;
                    finger = finger.next();
                }
                if ( finger != null ) {
                    prev.setNext(finger.next());
                    flip = true;
                }

            }
        }   
        return flip;
    }
    
    public static void main(String[] args) {
        
        SinglyLinkedList<Integer> nums = new SinglyLinkedList<Integer>();
        
        // Add values to the list
        for (int i = 0; i < 10; ++i) {
            nums.addLast(i);
        }
        nums.addLast(0);
        nums.addLast(1);
        nums.addLast(2);
        
        // Test the instance methods
        // TODO: add your own tests of the instance methods
        System.out.println(nums.toString());
        System.out.println("*Contain Duplicates?*");
        System.out.println(nums.containsDuplicates());
        System.out.println(nums.remove(0));
        
    }
}

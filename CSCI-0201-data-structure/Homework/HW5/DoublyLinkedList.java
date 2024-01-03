import javax.swing.event.TableModelListener;

/**
* A partial doubly-linked list implementation
* CSCI 201 Homework 5
*
* @author Xianzhi Wang 
* @param <E>
*/
public class DoublyLinkedList<E> {
    protected Node head;
    protected Node tail;
    protected int count;
    
    /**
    * Constructs an empty list. 
    */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }
    
    // TODO: replace this line with a Javadoc comment
    public void addFirst(E value) {
        
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.setNext(null);
            head.setPrev(null);
            count++;
        } else {

        newNode.setNext(head);
        newNode.setPrev(null);
        head.setPrev(newNode);
        head = newNode;
        count++;
        }
    }
    
    // TODO: replace this line with a Javadoc comment
    public void addLast(E value) {
        Node newNode = new Node(value);
        if ( tail == null ){
            tail = newNode;
            tail.setNext(null);
            tail.setPrev(null);
            count++;
        }
        else{

            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(null);
            tail = newNode;
            count++;

        }
    }
    
    // TODO: replace this line with a Javadoc comment
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        else {
            E returnValue = head.value();
            head = head.next();
            if (head == null) {
                tail = null;
            }
            else {
                head.setPrev(null);
            }
            count--;
            return returnValue;
        }
    }
    
    /**
    * Removes the last element in this list.
    * 
    * @return value of last element or null if empty list
    */
    public E removeLast() {
        if (tail == null) {
            return null;
        }
        else {
            E returnValue = tail.value();
            tail = tail.prev();
            if (tail == null) {
                head = null;
            }
            else {
                tail.setNext(null);
            }
            count--;
            return returnValue;
        }
    }
    
    /**
    * Returns a String representation of this list.
    * 
    * @return String representation enclosed in [ ]
    */
    public String toString() {
        Node finger = head;
        String result = "[ ";
        while (finger != null) {
            result += finger.toString() + " ";
            finger = finger.next();
        }
        result += "]";
        return result;
    }
    
    /**
    * Returns the number of elements in this list.
    * 
    * @return the number of elements in this list
    */
    public int size() {
        return count;
    }
    
    public static void main(String[] args) {
        
        DoublyLinkedList<Integer> nums = new DoublyLinkedList<Integer>();
        
        // Test the instance methods
        // TODO: add your own tests of the instance methods
        for (int i = 0; i < 10; ++i) {
            nums.addLast(i);
        }
        nums.addLast(0);
        nums.addLast(1);
        nums.addLast(2);
        nums.addFirst(-1);
        nums.addFirst(-2);
        System.out.println(nums.toString());
        System.out.println(nums.count);
        
        
    }
    
    /**
    * Node class for DoublyLinkedList
    */
    protected class Node {
        private E data;
        private Node next;
        private Node prev;
        
        /**
        * Constructs a Node.
        * 
        * @param v the value at this Node
        * @param next reference to the next Node 
        * @param prev reference to the previous Node 
        */
        public Node(E v, Node next, Node prev) {
            data = v;
            this.next = next;
            this.prev = prev;
            if (next != null) {
                next.setPrev(this);
            }
            if (prev != null) {
                prev.setNext(this);
            }
        }
        
        /**
        * Constructs a Node with null references.
        * 
        * @param v the value to be stored in this Node
        */
        public Node(E v) {
            this(v, null, null);
        }
        
        /**
        * Returns the Node referenced by next.
        * 
        * @return returns reference to the next Node 
        */
        public Node next() {
            return next;
        }
        
        /**
        * Returns the Node referenced by prev.
        * 
        * @return returns reference to the prev Node 
        */
        public Node prev() {
            return prev;
        }
        
        /**
        * Sets the next field of this Node.
        * 
        * @param next Node that will be referenced by next
        */
        public void setNext(Node next) {
            this.next = next;
        }
        
        /**
        * Sets the prev field of this Node.
        * 
        * @param prev Node that will be referenced by prev
        */
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
        /**
        * Returns the value field of this Node.
        * 
        * @return value at Node
        */
        public E value() {
            return data;
        }
        
        /**
        * Sets the value field of this Node.
        * 
        * @param value value to be stored at this Node
        */
        public void setValue(E value) {
            data = value;
        }
        
        /**
        * Returns a String representation of this node.
        * 
        * @return String representation of this Node, enclosed in < >
        */
        public String toString() {
            return "<Node: "+value()+">";
        }
    }
}

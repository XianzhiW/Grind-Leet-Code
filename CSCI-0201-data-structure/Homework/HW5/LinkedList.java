/**
* A partial linked list implementation
* CSCI 201
*
* @param <E>
*/
public class LinkedList<E> { 
    protected Node head; 
    
    /**
    * Constructs an empty list. 
    */
    public LinkedList() { 
        head = null; 
    } 
    
    /**
    * Inserts the specified value at the beginning of this list.
    *
    * @param value the value to add
    */	
    public void addFirst0(E value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
    }
    
    /**
    * Inserts the specified value at the beginning of this list.
    *
    * @param value the value to add
    */		
    public void addFirst(E value) {
        // note order that things happen:
        // right hand side gets evaluated and head is a parameter
        // the result of the right hand side then gets associated with head
        head = new Node(value, head); 
    }
    
    /**
    * Removes and returns the first element in this list.
    *
    * @return value of first element or null if empty list
    */
    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E returnValue = head.value(); 
            head = head.next(); // move head down the list 
            return returnValue;
        } 
    }
    
    /**
    * Returns the first value in this list.
    *
    * @returns the first value in this list
    */
    public E getFirst() {
        return head == null ? null : head.value(); 
    }
    
    /**
    * Returns true if this list contains the specified value.
    *
    * @param value to be searched for in this list
    * @return true if this list contains the specified element
    */
    public boolean contains(E value){ 
        Node finger = head; 
        
        while (finger != null && !finger.value().equals(value)) { 
            finger = finger.next(); 
        }
        
        return finger != null; 
    }
    
    /**
    * Returns true if this list contains the specified value.
    *
    * @param value to be searched for in this list
    * @return true if this list contains the specified element
    */
    public boolean recursiveContains(E value) {
        return containsHelper(head, value);
    }
    
    // Tail-recursive private helper function for recursiveContains
    private boolean containsHelper(Node current, E value) {
        if (current == null) {
            return false;
        } else if (current.value().equals(value)) {
            return true;
        } else {
            return containsHelper(current.next(), value);
        }
    }
    
    /**
    * Removes all elements from this list.
    */
    public void clear() { 
        head = null; 
    }
    
    /**
    * Removes the first occurrence of value from this list.
    * Assumes the list is non-empty.
    *
    * @param value the value to be removed from this list
    */
    public void removeWithProblems(E value) {
        if (head.value().equals(value)) {
            head = head.next();
        } else {
            Node finger = head.next(); 
            Node prev = head;
            
            while (finger != null && !finger.value().equals(value)) {
                prev = finger;
                finger = finger.next();
            }
            
            if (finger != null) {
                prev.setNext(finger.next());
            }
        }
    }
    
    /**
    * Returns the node index of the first occurrence of value in this list.
    *
    * @param value the value to be searched for in this list
    */
    public int indexOf(E value) {
        int index = -1;
        
        Node finger = head;
        
        while (finger != null && !finger.value().equals(value)) {
            finger = finger.next();
            index++;
        }
        
        return index;
    }
    
    /**
    * Appends the specified value to the end of this list.
    *
    * @param value the value to add
    */
    public void addLast(E value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node finger = head;
            
            while (finger.next() != null) {
                finger = finger.next();
            }
            
            finger.setNext(new Node(value));
        }
    }
    
    /**
    * Returns the element at the specified position in this list.
    *
    * @param index index of the element to return
    * @return the element at the specified position in this list
    */
    public E get(int index){
        Node finger = head;
        
        for (int i = 0; i < index && finger != null; i++) {
            finger = finger.next();
        }
        
        return finger == null ? null : finger.value();
    }
    
    /**
    * Node class for LinkedList
    */
    protected class Node {
        private E data; 
        private Node next; 
        
        /**
        * Constructs a Node.
        *
        * @param v the value at this Node
        * @param next reference to the next Node  
        */
        public Node(E v, Node next) { 
            data = v; 
            this.next = next; 
        } 
        
        /**
        * Constructs a Node with null references.
        *
        * @param v the value to be stored in this Node
        */
        public Node(E v) { 
            this(v,null); 
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
        * Sets the next field of this Node.
        *
        * @param next Node that will be referenced by next
        */
        public void setNext(Node next) { 
            this.next = next; 
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
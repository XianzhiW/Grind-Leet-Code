// Name: Xianzhi Wang
// CSCI 201 Homework 1

public class AccessLevel {
    int minPermission = 2;
    /**
     * 
     * @param rights an array of integers describing the privilege level of each user to use some system resource.
     * @param minPermission an integer describing the minimum permission a user must have to use this resource.
     * @return a string indicating whether users can or cannot access this resource. `A` indicates user is allowed access, and `D` indicates user is denied access.
     */

    // return String of As and Ds based on rights and minPermission
    public String canAccess(int[] rights, int minPermission) {
        String mystr = "";

        int j = 0; 
        do {
            if (rights.length == 0) {
                mystr = mystr + "";
            }
            else if (rights[j] >= minPermission) {
                mystr = mystr + "A";
            }
            else {
                mystr = mystr + "D";
            }
            j++;
        } while (j < rights.length); 
        return mystr;
    }
    public static void main(String[] args) {
        // main can be used as is for testing
        AccessLevel obj = new AccessLevel();
        int[] list1 = { 0, 1, 2, 3, 4, 5 };
        int[] list2 = { 5, 3, 2, 10, 0 };
        int[] list3 = {};
        int[] list4 = { 34, 78, 9, 52, 11, 1 };
        System.out.println(obj.canAccess(list1, 2));
        System.out.println(obj.canAccess(list2, 20));
        System.out.println(obj.canAccess(list3, 20));
        System.out.println(obj.canAccess(list4, 49));
    }
}

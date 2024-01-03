// CS 201 Homework 4 - CountOccurrences
// Name: Xianzhi Wang 

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class CountOccurrences {
    
    // Instance variables
    protected String[] words;
    
    // Constructor initializes instance variables
    public CountOccurrences(String[] words) {
        this.words = words;
    }
    
    /**
     * This method returns how many times each element of words occurs as a white-space delimited string in parameter str
     * @param str
     * @return int[] This method returns an int array.
     */
    public int[] analyze(String str) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        for (String word : words){
            myMap.putIfAbsent(word, 0);
        }
        String[] data = str.split(" ");
        for (String word : words){
            for (int i = 0; i < data.length; i++){
                if (word.equals(data[i])){
                myMap.put(word, myMap.get(word)+1);
                }
            }
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++){
            result[i] = myMap.get(words[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"d", "c", "b", "a"};
        String str = "a a a b b c";
        CountOccurrences mycount = new CountOccurrences(words);
        int[] results = mycount.analyze(str);
        System.out.println("***");
        System.out.println(results.toString());
        System.out.println("***");
    }
    
}


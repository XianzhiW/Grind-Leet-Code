// CS 201 Homework 4 - UniqueWords
// Name: Xianzhi Wang

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueWords {
    
    // Instance variables
    protected String[] words;
    
    // Constructor initializes instance variables
    public UniqueWords(String[] words) {
        this.words = words;
    }
    
    // Returns number of unique strings in words that begin with prefix
    public int begins(String prefix) {
        /*
         * alternative code that does not use HashMap
         */
        // int length;
        // int counter = 0;
        // int loopCounter = 0;
        // String[] seenBefo = new String[words.length];
        // length = prefix.length();
        // for (String word : words) {
        //     if (word.length() >= length) {
        //         if (word.substring(0, length).equals(prefix)) {
        //             if (!Arrays.asList(seenBefo).contains(word)) {
        //             counter++;

        //             seenBefo[loopCounter] = word;
        //             loopCounter++;
        //             }
        //         }
        //     }
        // }
        HashMap<String, Integer> mymap = new HashMap<String, Integer>();
        int length;
        length = prefix.length();
        for (String word : words){
            if (word.length() >= length) {
                if (word.substring(0, length).equals(prefix)) {
                    mymap.putIfAbsent(word, 1);
            
        
                }
            }
        }
        return mymap.size();
    }
    
    public static void main(String[] args) {
        // main can be used as is for testing
        String[] words1 = { "you", "can", "totally", "you", "can", "do", "this" };
        UniqueWords test1 = new UniqueWords(words1);
        System.out.println("***");
        System.out.println(test1.begins("yo"));
        System.out.println(test1.begins("t"));
        System.out.println("***");

        System.out.println(test1.begins("zebra"));
        String[] words2 = { "zebras", "zebra", "yak", "yaks", "zebras", "zebra", "yak", "yaks" };
       
       
        String[] words3 = { "one", "two", "one", "two" };
        UniqueWords test3 = new UniqueWords(words3);
        System.out.println(test3.begins("two"));
        System.out.println("done");
    }
    
}
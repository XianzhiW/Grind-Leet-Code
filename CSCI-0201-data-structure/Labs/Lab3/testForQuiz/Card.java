package testForQuiz;

import java.util.ArrayList;

public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit.toLowerCase();
    }

    public String toString() {
        return number + " of " + suit;
    }
    public String concatStr (String a, String b, String c){
        return a+b+c;
    }

    public int sum;
    public void setSum(int[] scores){
        sum = scores[0] + scores[1];
    }

    public static void main(String[] args) {
        Card card = new Card(5, "diamonds");
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        // for (char item: vowels) {
        //     System.out.println(item);
        // }
        
        for (int i = 0; i < vowels.length; ++i){
            System.out.println(vowels[i]);
        }

        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(4);
        numList.add(6);
        numList.add(1);
        numList.add(0);
        System.out.println(numList.toString());
        if (!numList.isEmpty()){
            numList.remove(2);
            numList.remove(1);
        }
        System.out.println(numList.toString());

        Card mycar = new Card(0, "diamond");
        int[] newgame = new int[2];
        newgame[0] = 10;
        newgame[1] = 20;
        mycar.setSum(newgame);
        // System.out.println(setSum.mycar);
        System.out.println("yes");
        int x = 50;
        int y = (x < 20) ? 100 : x;
        System.out.println(y);


        // int count;
        // for(count = 1; count < 10; ++count) {
        //     numList.add(count);

        // }
        // System.out.println(numList.get(4));

    }
    
}

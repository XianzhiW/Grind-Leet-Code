// Name: Xianzhi Wang 
// CSCI 201 Lab 2

public class Warmup {

    // Counts how many cards are of a suit
    public static int countSuit(Card[] cards, String suit) {
        int myCount = 0;
        for (int i = 0; i < cards.length; i++ ){
            if (cards[i].getSuit() == suit){
                myCount++;
            }

        }
        return myCount;
    }

    public static void main(String[] args) {
        Card[] cards = new Card[4];
        cards[0] = new Card(4, "clubs");
        cards[1] = new Card(12, "diamonds");
        cards[2] = new Card(1, "hearts");
        cards[3] = new Card(10, "diamonds"); 
        System.out.println(countSuit(cards, "diamonds"));
    }
    
}

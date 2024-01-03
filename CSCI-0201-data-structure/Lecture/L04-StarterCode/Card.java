// CS 201 Card class

public class Card {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 13;
	
	private int number;
	private String suit;
	
	public Card(int number, String suit) {
		if (isValidNumber(number)) {
			this.number = number;
		} else {
			System.out.println("Invalid card number: " + number);
			System.out.println("Defaulting to 1");
			this.number = 1;
		}
		if (isValidSuit(suit)) {
			this.suit = suit;
		} else {
			System.out.println("Invalid suit: " + suit);
			System.out.println("Defaulting to hearts");
			this.suit = "hearts";
		}		
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void cheat() {
		number = 1; // ACE!
	}
		
	public boolean equals(Card other) {
		// fill this in
        return false;	
	}
	
	public String toString() {
        // fill this in
        return "";
	}
	
	private boolean isValidNumber(int number) {
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}
	
	private boolean isValidSuit(String suit) {
		return suit.equals("spades") ||
			   suit.equals("hearts") ||
			   suit.equals("clubs") ||
			   suit.equals("diamonds");
	}
	
	public static void main(String[] args) {

        // fill this in to create a card
        // and print its representation

	}
}
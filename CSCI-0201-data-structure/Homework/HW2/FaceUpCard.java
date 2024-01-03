// Name: Xianzhi Wang 
// CSCI 201 Homework 2

public class FaceUpCard extends Card {

    private boolean faceUp;

    /**
     * Create a new FaceUpCard with number and suit
     * @param number the card number
     * @param suit the card suit
     */
    public FaceUpCard(int number, String suit) {
        super(number, suit);
        faceUp = false;
    }

    /**
     * Returns whether card is face up
     */
	public boolean isFaceUp() {
		return faceUp;
	}
    	
    /**
     * Flips a card from face-down to face-up or face-up to face-down
     */
	public void flip() {
		faceUp = !faceUp;
	}

    /**  
     * Returns the card's value in the FaceUp game
     * Number cards have their number as the value
     * Ace is 11, and Jack, Queen, and King are 10
    */
    public int getCardValue() {
            if (this.getNumber() == 1){
                return 11;
            }
            else if ((this.getNumber() <= 10) && (this.getNumber() >= 2)) {
                return this.getNumber();
            }
            else {
                return 10;
            }
	}

    /**
     * Returns whether card is a red card, ie with suit "hearts" or "diamonds"
     */
	public boolean isRedCard() {
        boolean isRed = false;
        if ( (this.getSuit() == "hearts") || (this.getSuit() == "diamonds") ){
            isRed = true;
        }
        return isRed;
	}
	

}









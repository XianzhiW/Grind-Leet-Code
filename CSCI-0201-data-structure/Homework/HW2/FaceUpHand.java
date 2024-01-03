// Name: Xianzhi Wang 
// CSCI 201 Homework 2

/**
 * Keeps track of the cards and and answers questions
 * for the FaceUp card game. 
 * 
 * Red cards (hearts and diamonds) award positive points, while black cards 
 * (clubs and spades) award negative points.  Cards 2-10 have points worth 
 * their face value; Jack, Queen and King are 10; and Ace is 11.
 */
public class FaceUpHand {

	private FaceUpCard[] cards;
	
	/**
	 * Create a new FaceUp card game state, which consists of the
	 * array cards of size numCards 
	 * 
	 * @param numCards number of cards in the game
	 */
    public FaceUpHand(int numCards) {
        // 1. set the instance variable cards equal to a new array (size numCards) of type FaceUpCard
        // 2. create a variable dealer of type CardDealer for 1 deck
        // 3. loop through the cards array and set each value to dealer.next()
		cards = new FaceUpCard[numCards]; 
		CardDealer dealer = new CardDealer(1);

		for (int i = 0; i < numCards ; i++){
		cards[i] = dealer.next();
		}
	}
    /**
     * Return the FaceUpCard in position cardIndex of cards
     * 
     * @return the element of cards specified by cardIndex
     */
    public FaceUpCard getCard(int cardIndex) {
        return cards[cardIndex]	;
    }
	
	/**
	 * Flip the card over at this index  
     * Card indices start at 0 and go up the cards.length-1
	 * 
	 * @param cardIndex the index of the card to flip over
	 */
    public void flipCard(int cardIndex) {
		cards[cardIndex].flip();
	}
	
    /**
	 * Calculate the best possible score for the current cards
	 * 
	 * @return the optimal score
	 */
	public int calculateOptimal() {
		int optimalScore = 0;
		for ( int i = 0; i < cards.length; i++){
			if (cards[i].isRedCard()) {
				optimalScore = optimalScore + cards[i].getCardValue();
			}
		}
		
        return optimalScore;
	}
	/**
	 * Calculate the total score for the cards that are face up 
     * 
	 * @return the total score for face-up cards
	 */	
	public int faceUpTotal() {
        // Hint: use getCardValue() and remember red cards have positive value
        // and black cards have negative value
		int totalScoreFaceUpCards = 0;
		for ( int i = 0; i < cards.length; i++){
			if (cards[i].isFaceUp()) {
				if (cards[i].isRedCard() == true){
					totalScoreFaceUpCards = totalScoreFaceUpCards + cards[i].getCardValue();
				}
				else {totalScoreFaceUpCards = totalScoreFaceUpCards - cards[i].getCardValue();
				} 
			}
		}
        return totalScoreFaceUpCards;
	}
	/**
	 * Calculate the total score for the cards that are face down 
	 * 
	 * @return the total score for face-down cards
	 */	
	public int faceDownTotal() {
        // Hint: use getCardValue() and remember red cards have positive value
        // and black cards have negative value
		int totalScoreFaceDownCards = 0;
		for ( int i = 0; i < cards.length; i++){
			if (!cards[i].isFaceUp()) {
				if (cards[i].isRedCard() == true){
					totalScoreFaceDownCards = totalScoreFaceDownCards + cards[i].getCardValue();
				}
				else {totalScoreFaceDownCards = totalScoreFaceDownCards - cards[i].getCardValue();
				} 
			}
		}
        return totalScoreFaceDownCards;
	}

	public String toString() {
		String holder = "";
		for (int i = 0; i < cards.length; i++){
			if (cards[i].isFaceUp()){
				 holder = holder + cards[i].toString() + "|";

			}
			else {
				 holder = holder + "FACE-DOWN" + "|";
			}
		}
		String holderTruncate = holder.substring(0, holder.length()-1);
		return holderTruncate;
	}


	

}
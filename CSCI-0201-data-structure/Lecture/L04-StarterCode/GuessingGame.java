// CS 201 GuessingGame
import java.util.InputMismatchException;;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

	protected int maxGuess;
	
    // constructor initializes maxGuess
	public GuessingGame(int maxGuess){
		// fill this in to initialize instance variable
	}

    // playGame continues until user guesses correctly
    public void playGame() {

		// pick a random number
		Random rand = new Random();
        
		// replace this to set pick = random number 1..maxGuess
        int pick = rand.nextInt(maxGuess) + 1; 

		int guess = -1;
		Scanner in = new Scanner(System.in);

		while (guess != pick) {
			System.out.print("Enter a guess: ");
			
            try{
            guess = in.nextInt();

            if (guess == pick){
                System.out.println("Correct!");
            } else if (guess < pick){
                System.out.println("too low");
            } else {
                System.out.println("too high");
            }
		    } catch(InputMismatchException e) {
            System.out.println("guess need to be an int");
            in.nextLine();
            }
		    in.close();
    }

    public static void main(String[] args) {
        // fill this in to call playGame
        GuessingGame game = new GuessingGame(20);
        game.playGame();
    }
}

































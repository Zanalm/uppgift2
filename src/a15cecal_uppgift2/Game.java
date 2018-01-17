package a15cecal_uppgift2;
import java.util.Scanner;

public class Game {
	private int score;
	private int computerVictory;
	private int userVictory;
	
	private void addVictory() {
		if(score == 1) {
			computerVictory += 1;
		}
		else if(score == 0) {
			userVictory += 1;
		}
		//If it's a draw, no victory is added, hence no code for that
	}

	//uses value from wonRound() in Deck.java to return "x wins!" or a draw
	private void whoWins() {
		if(score == 1) {
			System.out.println("Computer wins!");
		}
		else if(score == 0) {
			System.out.println("You win!");
		}
		else if(score == 2)	{
			System.out.println("Draw!");
		}
	}
	
	private int getComputerVictories() {
		return computerVictory;
	}
	
	private int getUserVictories() {
		return userVictory;
	}

	
	Game() {
		Deck deck1 = new Deck();
		Scanner scan = new Scanner(System.in);
		String quit = " ";
		System.out.println("Welcome to an awesome game of cards!");
		
		// What will happen if the user decides to quit
		while(!quit.equals("imma fold")) {
			System.out.println("------Card drawn:------");
			deck1.shuffleDeck();
			deck1.drawCard();
			deck1.printScores();
			score = deck1.wonRound(); //store information to use in method whoWins()
			addVictory();
			whoWins();
			System.out.println("");
			System.out.println("--Current score--");
			System.out.println("user: " + getUserVictories());
			System.out.println("computer: " + getComputerVictories());
			System.out.println("");
			System.out.println("------Hit Enter to play again or write \"imma fold\" to quit------");
			quit = scan.nextLine();
		}
		System.out.println("I'd pull out too...");

	}
}

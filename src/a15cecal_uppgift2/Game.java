package a15cecal_uppgift2;
import java.util.Scanner;

public class Game {
	private int score;
	private int computerVictory;
	private int humanVictory;
	
	private void addVictory() {
		if(score == 1) {
			computerVictory += 1;
		}
		else if(score == 0) {
			humanVictory += 1;
		}
		//If it's a draw, no victory is added, thus there's no code for that
	}

	//uses value from wonRound() in Deck.java to return "x wins!" or a draw
	private void whoWins() {
		if(score == 1) {
			System.out.println("Computer wins!");
		}
		else if(score == 0) {
			System.out.println("Human wins!");
		}
		else if(score == 2)	{
			System.out.println("It's a draw!");
		}
	}
	
	private int getComputerVictories() {
		return computerVictory;
	}
	
	private int getHumanVictories() {
		return humanVictory;
	}

	
	Game() {
		Deck deck1 = new Deck();
		Scanner scan = new Scanner(System.in);
		String quit = " ";
		System.out.println("Welcome to an awesome game of cards!");
		
		// What will happen if the user decides to quit
		while(!quit.equals("imma fold")) {
			System.out.println("------Cards drawn:------");
			deck1.shuffleDeck();
			deck1.drawCards();
			deck1.printScores();
			score = deck1.wonRound(); //store information to use in method whoWins()
			addVictory();
			System.out.println("");
			whoWins();
			System.out.println("Victories, human: " + getHumanVictories() + ", computer: " + getComputerVictories());
			System.out.println("");
			System.out.println("------Hit Enter to play again or write \"imma fold\" to quit------");
			quit = scan.nextLine();
		}
		System.out.println("I'd pull out too...");

	}
}

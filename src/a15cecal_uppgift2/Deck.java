package a15cecal_uppgift2;

import java.util.*;

public class Deck {
	private ArrayList<Card> deck1 = new ArrayList<Card>();
	private int returnedValue;
	int computerCardValue;
	int userCardValue;

	// Creates cards with different suits and numbers
	private void createDeck(ArrayList<Card> array) {

		for (int i = 0; i < 12; i++) {
			deck1.add(new Card("Diamonds", i + 1));
		}

		for (int i = 0; i < 12; i++) {
			deck1.add(new Card("Hearts", i + 1));
		}

		for (int i = 0; i < 12; i++) {
			deck1.add(new Card("Spades", i + 1));
		}

		for (int i = 0; i < 12; i++) {
			deck1.add(new Card("Clubs", i + 1));
		}
	}

	private Card getCard(int number) {
		Card drawnCard = deck1.get(number);
		return drawnCard;

	}

	// Gets the total value of a card, bonus included for the different card
	// types
	public int getCardValue(Card Card) {
		int CardValue = 0;
		String CardType;
		CardType = Card.getType();
		if (CardType == "Diamonds") {
			CardValue = 4;
		} else if (CardType == "Clubs") {
			CardValue = 6;
		} else if (CardType == "Hearts") {
			CardValue = 8;
		} else if (CardType == "Spades") {
			CardValue = 10;
		} else {
			System.out.println("Fuck you");
		}
		CardValue += Card.getNumber();
		return CardValue;
	}

	// Returns 2 different values to show whether the user or the computer won
	// the round
	public int wonRound() {
		if (computerCardValue > userCardValue) {
			returnedValue = 1;
		} else if (computerCardValue < userCardValue) {
			returnedValue = 0;
		} else if (computerCardValue == userCardValue) {
			returnedValue = 2;
		}
		return returnedValue;
	}

	public void shuffleDeck() {
		Collections.shuffle(deck1);
	}

	public void drawCard() {

		Card drawnCard;
		// Sets two cards for the computer and the user
		for (int i = 0; i < 2; i++) {

			drawnCard = getCard(i);
			if (i == 0) {
				System.out.println("Computer draws " + drawnCard);
				computerCardValue = getCardValue(drawnCard);
			} else if (i == 1) {
				System.out.println("User draws " + drawnCard);
				userCardValue = getCardValue(drawnCard);
			}
		}
	}

	public void printScores() {
		System.out.println("Computer scores " + computerCardValue + " - user scores " + userCardValue);
	}

	Deck() {

		createDeck(deck1);

	}

}
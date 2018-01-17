package a15cecal_uppgift2;
import java.util.*;

public class Deck {
	private ArrayList<Cards> deck1 = new ArrayList<Cards>();
	private  int returnedValue;
	int computerCardsValue;
	int humanCardsValue;
	
	//Creates cards with different suits and numbers
	private void createDeck(ArrayList<Cards> array)
	{
	
		for (int i = 0; i < 12; i++) {
			deck1.add(new Cards("Diamonds", i+1)); 
		}
		
		for(int i = 0; i < 12; i++)
		{
			deck1.add(new Cards("Hearts", i+1));
		}
		
		for(int i = 0; i < 12; i++)
		{	
			deck1.add(new Cards("Spades", i+1));
		}
		
		for(int i = 0; i < 12; i++)
		{
			deck1.add(new Cards("Clubs", i+1));
		}
	}
	
	private Cards getCards(int number)
	{
		Cards drawnCards = deck1.get(number);
		return drawnCards;
		
	}
	
	//Gets the total value of a card, bonus included for the different card types
	public int getCardsValue(Cards Cards)
	{
		int CardsValue = 0;
		String CardsType;
		CardsType = Cards.getType(); 
		if(CardsType == "Diamonds")
		{
			CardsValue = 4;
		}
		else if (CardsType == "Clubs")
		{
			CardsValue = 6; 
		}
		else if (CardsType == "Hearts")
		{
			CardsValue = 8;
		}
		else if (CardsType == "Spades")
		{
			CardsValue = 10;
		}
		else
		{
			System.out.println("Fuck you");
		}
		CardsValue += Cards.getNumber();
		return CardsValue;
	}

	//Returns 2 different values to show whether human or computer wins round
	public int wonRound()
	{
		if(computerCardsValue > humanCardsValue)
		{
			returnedValue = 1;
		}
		else if(computerCardsValue < humanCardsValue)
		{
			returnedValue = 0;
		}
		else if(computerCardsValue == humanCardsValue)
		{
			returnedValue = 2;
		}
		return returnedValue;
	}
	
	public void shuffleDeck()
	{
		Collections.shuffle(deck1);
	}
	
	public void drawCards()
	{
		
		Cards drawnCards;
		//Draw two Cards since both human and computer needs one
		for(int i = 0; i < 2; i++)
		{
			
			drawnCards = getCards(i);
			if(i == 0)
			{
				System.out.println("Computer draws " + drawnCards);
				computerCardsValue = getCardsValue(drawnCards);
			}
			else if(i == 1)
			{
				System.out.println("Human draws " + drawnCards);
				humanCardsValue = getCardsValue(drawnCards);
			}
		}
	}
	
	public void printScores()
	{
		System.out.println("Computer scores " + computerCardsValue + " - human scores " + humanCardsValue);
	}
	
	Deck() 
	{
		
		createDeck(deck1);
		
	}

}
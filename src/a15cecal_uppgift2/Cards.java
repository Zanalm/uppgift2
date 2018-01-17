package a15cecal_uppgift2;

public class Cards {
	private String cardType;
	private int cardNumber; 
	
	//constructor
	public Cards(String type, int number)
	{
		cardType = type;
		cardNumber = number;
	}
	
	public String getType()
	{
		return cardType;
	}
	
	public int getNumber()
	{
		return cardNumber;
	}
	
	//Used to return object with its variables in 
	//ArrayList rather than its memory address
	@Override
	public String toString()
	{
		return (cardNumber + " of "
				+ cardType);
				
	}
}

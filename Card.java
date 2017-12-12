public class Card {
	public static final String HEARTS = "H";
	public static final String SPADES = "S";
	public static final String DIAMONDS = "D";
	public static final String CLUBS = "C";
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	private String suit;
	private int number;

	public Card(String suit, int number){
		this.suit = suit;
		this.number = number;
	}
	
	
	public String toText(){
		return (getRealNumber() + suit);
	}
	
	public String getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}
	public String getRealNumber(){
		if(number == ACE){
			return "A";
		}else if(number == JACK){
			return "J";
		}else if(number == QUEEN){
			return "Q";
		}else if(number == KING){
			return "K";
		}else{
			return Integer.toString(number);
		}
	}
	

}

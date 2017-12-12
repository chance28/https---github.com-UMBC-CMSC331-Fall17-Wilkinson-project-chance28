import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		for (int i = 1; i <= 13; i++) {
			add(new Card(Card.CLUBS, i));
			add(new Card(Card.DIAMONDS, i));
			add(new Card(Card.HEARTS, i));
			add(new Card(Card.SPADES, i));
		}
	}

	public void add(Card c) {
		cards.add(c);
	}

	public void print() {
		System.out.println("Printing Cards: ");
		for (Card c : cards) {
			System.out.println(c.getRealNumber() + " of " + c.getSuit());
		}
	}
	public int getSize(){
		return cards.size();
	}
	public Card getRandom() {
		int i = (int) (Math.random() * getSize());
		Card c = cards.get(i);
		cards.remove(i);
		return c;
	}
}

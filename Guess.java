public class Guess {

	boolean match;
	Position p1;
	Position p2;
	Card c1;
	Card c2;

	public Guess(boolean match, Position p1, Position p2, Card c1, Card c2) {
		this.match = match;
		this.p1 = p1;
		this.p2 = p2;
		this.c1 = c1;
		this.c2 = c2;
	}
}

import java.util.ArrayList;

public class Game {
	int p1Matches = 0;
	int p2Matches = 0;
	int numGuesses = 0;
	int winningPlayer = -1;
	int streak = 0;
	ArrayList<Guess> Guesses = new ArrayList<Guess>();
	Card[][] rows = new Card[4][13];

	public Game() {
		Deck deck = new Deck();

		// setup game
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				rows[i][j] = deck.getRandom();

			}
		}
	}

	public void printStats() {
		System.out.println("--- printing game stats ---");
		System.out.println("p1Matches: " + p1Matches);
		System.out.println("p2Matches: " + p2Matches);
		System.out.println("numGuesses: " + numGuesses);
		System.out.println("winning Player: " + winningPlayer);
		System.out.println("best streak: " + streak);

	}

	// runs the game
	public void start() {
		System.out.println("starting game");
		while (!isGameOver()) {
			p1Guess();
			p2Guess();
		}
		printStats();
	}

	public boolean isGameOver() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (rows[i][j] != null) {
					return false;
				}
			}
		}
		gameOver();
		return true;
	}

	// do when a game is over
	public void gameOver() {
		if (p1Matches > p2Matches) {
			System.out.println("player 1 wins");
			winningPlayer = 1;
		} else {
			System.out.println("player 2 wins");
			winningPlayer = 2;
		}

	}

	// player 1 takes a turn(recursive for repeate turn)
	public void p1Guess(int s) {
		if (!isGameOver()) {
			int a = (int) (Math.random() * 4);
			int b = (int) (Math.random() * 13);
			while (rows[a][b] == null) {
				a = (int) (Math.random() * 4);
				b = (int) (Math.random() * 13);
			}

			int c = (int) (Math.random() * 4);
			int d = (int) (Math.random() * 13);
			while (rows[c][d] == null) {
				c = (int) (Math.random() * 4);
				d = (int) (Math.random() * 13);
			}
			Position g1 = new Position(a, b);
			Position g2 = new Position(c, d);
			Card c1 = rows[a][b];
			Card c2 = rows[c][d];
			boolean isMatch = false;
			if (c1.getNumber() == c2.getNumber()) {
				isMatch = true;
				p1Matches++;
				rows[a][b] = null;
				rows[c][d] = null;
				System.out.println("player 1 matched " + c1.toText() + " and "
						+ c2.toText());
				p1Guess(s + 1);

			} else {
				if (s > streak) {
					streak = s;
				}
			}

			Guesses.add(new Guess(isMatch, g1, g2, c1, c2));
			numGuesses++;
		}
	}

	// player 2 takes a turn(recursive for repeate turn)
	public void p2Guess(int s) {

		if (!isGameOver()) {
			int a = (int) (Math.random() * 4);
			int b = (int) (Math.random() * 13);
			while (rows[a][b] == null) {
				a = (int) (Math.random() * 4);
				b = (int) (Math.random() * 13);
			}

			int c = (int) (Math.random() * 4);
			int d = (int) (Math.random() * 13);
			while (rows[c][d] == null) {
				c = (int) (Math.random() * 4);
				d = (int) (Math.random() * 13);
			}
			Position g1 = new Position(a, b);
			Position g2 = new Position(c, d);
			Card c1 = rows[a][b];
			Card c2 = rows[c][d];
			boolean isMatch = false;
			if (c1.getNumber() == c2.getNumber()) {
				isMatch = true;
				p2Matches++;
				rows[a][b] = null;
				rows[c][d] = null;
				System.out.println("player 2 matched " + c1.toText() + " and "
						+ c2.toText());
				p2Guess(s + 1);

			} else {
				if (s > streak) {
					streak = s;
				}
			}

			Guesses.add(new Guess(isMatch, g1, g2, c1, c2));
			numGuesses++;
		}

	}

	public void p1Guess() {
		p1Guess(0);
	}

	public void p2Guess() {
		p2Guess(0);
	}

	public void print() {
		for (int i = 0; i < 4; i++) {
			System.out.print("[");
			for (int j = 0; j < 13; j++) {
				Card c = rows[i][j];
				System.out.print(" " + c.getRealNumber() + c.getSuit() + " ");

			}
			System.out.println("]");
		}
	}

}

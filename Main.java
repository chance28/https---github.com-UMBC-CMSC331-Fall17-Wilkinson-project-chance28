import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		int totalGuesses = 0;
		int averageGuesses = 0;
		int gamesPlayed = 10;
		int p1TotalMatches = 0;
		int p2TotalMatches = 0;
		int p1AvgMatch = 0;
		int p2AvgMatch = 0;
		int mostGuesses = 0;
		int mostGuesssesGame = 0;
		int leastGuessesGame = 0;
		int leastGuesses = 0;
		int longestStreak = 0;
		int p1Wins = 0;
		int p2Wins = 0;
		int winningPlayer = -1;
		ArrayList<Game> games = new ArrayList<Game>();
		for (int i = 0; i < gamesPlayed; i++) {
			games.add(new Game());
		}
		for (Game g : games) {
			g.start();
		}

		System.out.println("-----------------------------------");
		int i = 1;

		for (Game g2 : games) {
			g2.printStats();
			p1TotalMatches += g2.p1Matches;
			p2TotalMatches += g2.p2Matches;
			totalGuesses += g2.numGuesses;
			if (g2.numGuesses > mostGuesses) {
				mostGuesses = g2.numGuesses;
				mostGuesssesGame = i;
			}
			if (g2.numGuesses < leastGuesses) {
				leastGuesses = g2.numGuesses;
				leastGuessesGame = i;
			}
			if (g2.streak > longestStreak) {
				longestStreak = g2.streak;
			}
			if (g2.winningPlayer == 1) {
				p1Wins++;
			} else {
				p2Wins++;
			}
			if (p1Wins > p2Wins) {
				winningPlayer = 1;
			} else {
				winningPlayer = 2;
			}

			i++;
		}
		p1AvgMatch = p1TotalMatches / gamesPlayed;
		p2AvgMatch = p2TotalMatches / gamesPlayed;
		averageGuesses = totalGuesses / gamesPlayed;

		// print stats
		System.out
				.println("gamesplayed, averagep1mathes, averagep2matches, most guesses, leaset guesses, average guesses per game, longest streak, player that won most");
		System.out.println(gamesPlayed);
		System.out.println(p1AvgMatch);
		System.out.println(p2AvgMatch);
		System.out.println(mostGuesssesGame);
		System.out.println(leastGuessesGame);
		System.out.println(averageGuesses);
		System.out.println(longestStreak);
		System.out.println(winningPlayer);

		// output to file

		BufferedWriter bw = null;
		FileWriter fw = null;
		String FILENAME = "./out.txt";
		try {
			System.out.println("writing to file");
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(gamesPlayed + ",");
			bw.write(p1AvgMatch + ",");
			bw.write(p2AvgMatch + ",");
			bw.write(mostGuesssesGame + ",");
			bw.write(leastGuessesGame + ",");
			bw.write(averageGuesses + ",");
			bw.write(longestStreak + ",");
			bw.write(winningPlayer +"");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
}

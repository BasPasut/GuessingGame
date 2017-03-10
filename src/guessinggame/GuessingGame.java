package guessinggame;

import java.util.Random;

/**
 * Class for GuessingGame.
 * 
 * @author Pasut Kittiprapas.
 */
public class GuessingGame {
	/* properties of a guessing game */
	public int upperBound;
	public int secret;
	private String hint;
	public int count;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max value for the secret number (>1).
	 */
	public GuessingGame(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and " + upperBound;
		this.count = 0;
	}

	/**
	 * count the number of guesses
	 * 
	 * @return the number of guesses
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Create a random number between 1 and limit.
	 * 
	 * @param limit
	 *            is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	public int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}
	
	/**
	 * Guess the number and give it true or false.
	 * @param number
	 * @return true or false from guessing.
	 */
	public boolean guess(int number) {
		this.count++;
		if (number == this.secret) {
			this.hint = "The secret number is " + this.secret + ".";
			return true;
		} else if (number > this.secret) {
			this.hint = "Sorry, your guess is too large. Try again.";
			return false;
		} else {
			this.hint = "Sorry, your guess is too small. Try again.";
			return false;
		}
	}

	/**
	 * Return a hint based on the most recent guess.
	 * 
	 * @return hint based on most recent guess
	 */
	public String getHint() {
		return this.hint;
	}

	protected void setHint(String hint) {
		this.hint = hint;
	}
}

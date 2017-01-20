package GuessingGame;

import java.util.Random;

/** 
 * Game of guessing a secret number.-- write a description here
 * @author Your Name               -- your name, no parenthesis.
 */
public class GuessingGame {
	/* properties of a guessing game */
	private int upperBound;
	private int secret;
	private String hint;
	public int count;
	
	/**
	 * Initialize a new game.
	 * @param upperbound is the max value for the secret number (>1).
	 */
	public GuessingGame(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and "+ upperBound;
		this.count = 0;
	}
	public int getSecretNumber(){
		return this.secret;
	}
	
	/** 
	 * Create a random number between 1 and limit.
	 * @param limit is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	public int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}

	public boolean guess(int number) {
		this.count++;
		if (number == this.secret) {
			this.hint = "Correct. The secret is " + number;
			return true;
		} else if (number > this.secret) {
			this.hint = "Sorry, your guess is too large.";
			return false;
		} else{
			this.hint = "Sorry, your guess is too small.";
			return false;
		}
	}
	
	/** 
	 * Return a hint based on the most recent guess.
	 * @return hint based on most recent guess
	 */
	public String getHint() {
		return this.hint;
	}

	protected void setHint(String hint) {
		this.hint = hint;
	}
}

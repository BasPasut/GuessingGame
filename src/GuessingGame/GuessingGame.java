package GuessingGame;

import java.util.Random;

public class GuessingGame {
	private int upperBound;
	private int secret;
	private String hint;

	public GuessingGame(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and "+ upperBound;

	}
	public int getSecretNumber(){
		return this.secret;
	}

	public int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}

	public boolean guess(int number) {
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

	public String getHint() {
		return this.hint;
	}

	protected void setHint(String hint) {
		this.hint = hint;
	}
}

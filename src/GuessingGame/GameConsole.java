package GuessingGame;

import java.util.Scanner;

public class GameConsole {
	static Scanner sc = new Scanner(System.in);
	/**
	 * The play method plays a game using input from a user.
	 * @param ...
	 * @return ...
	 */
	public int play(GuessingGame game) {
		int count = 1;
		String title = "Guessing Game";
		System.out.println(title);
		System.out.println(game.getHint());
		boolean running = true;
		while (running) {
			System.out.println("Your guess?");
			int ans = sc.nextInt();
			if (game.guess(ans) == false) {
				System.out.println(game.getHint());
				count++;
			} else {
				System.out.println(game.getHint());

				running = false;

			}
		}
		System.out.println("You used " + count + " guesses.");
		return game.getSecretNumber();

	}
}

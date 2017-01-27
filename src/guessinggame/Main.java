package guessinggame;

public class Main {
	/** create objects and start the game */
	public static void main(String args[]) {
		GuessingGame game = new GuessingGame(100);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}

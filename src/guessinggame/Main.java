package guessinggame;

import ui.GameUI;

public class Main {
	/** create objects and start the game */
	public static void main(String args[]) {
		GuessingGame game = new GuessingGame(100);
		new GameUI(game);
//		GameConsole ui = new GameConsole();
//		ui.play(game);
	}
}

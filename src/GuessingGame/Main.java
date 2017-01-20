package GuessingGame;

public class Main {
	public static void main(String args[]){
		GuessingGame game = new GuessingGame(100);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}

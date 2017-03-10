package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import guessinggame.GuessingGame;

public class GameUI extends JFrame {

	private JLabel label;
	private JTextField input;
	private JLabel usedGuess;
	private JPanel hint;
	private JPanel center;
	private JButton enter;
	private JButton giveup;
	private GuessingGame game;

	public GameUI(GuessingGame game) {
		this.game = game;
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Guess A Number");
		initComponents(game);
	}

	private void initComponents(GuessingGame game) {
		ButtonListener listener = new ButtonListener();
		ButtonListener2 listener2 = new ButtonListener2();
		this.setLayout(new BorderLayout());
		label = new JLabel("I'm thinking of a number between 1 and " + game.upperBound);
		hint = new JPanel();
		hint.setBackground(Color.green);
		hint.add(label);
		hint.setBorder(new TitledBorder("Hint"));
		this.add(hint, BorderLayout.NORTH);
		input = new JTextField(10);
		enter = new JButton("Enter");
		enter.addActionListener(listener);
		giveup = new JButton("Give Up");
		giveup.addActionListener(listener2);
		center = new JPanel();
		center.setBackground(Color.yellow);
		center.add(new JLabel("Enter your guess: "));
		center.add(input);
		center.add(enter);
		center.add(giveup);
		this.add(center, BorderLayout.CENTER);
		usedGuess = new JLabel(" You used 0 guess.");
		this.add(usedGuess, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);

	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int inputNum = Integer.parseInt(input.getText());
			boolean checking = game.guess(inputNum);

			if (checking) {
				label.setText(game.getHint() + " You used " + game.getCount() + " guesses.");
				label.setForeground(Color.RED);
				usedGuess.setForeground(Color.RED);
				input.setEnabled(false);
				enter.setEnabled(false);
			} else {
				label.setText(game.getHint());
				usedGuess.setText("You used " + game.getCount() + " guesses.");
			}

		}

	}

	class ButtonListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("The secret number is " + game.secret + ".");
			label.setForeground(Color.RED);
			usedGuess.setForeground(Color.RED);
			input.setEnabled(false);
			enter.setEnabled(false);

		}

	}
}

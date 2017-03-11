package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import guessinggame.GuessingGame;

/*
 * 
 * @author Pasut Kittiprapas
 */
public class GameUI extends JFrame implements KeyListener {

	private JLabel label;
	private JTextField input;
	private JLabel usedGuess;
	private JPanel hint;
	private JPanel center;
	private JPanel bottom;
	private JButton enter;
	private JButton giveup;
	private JButton retry;
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
		Retry listener3 = new Retry();
		this.setLayout(new BorderLayout());
		label = new JLabel("I'm thinking of a number between 1 and " + game.upperBound);
		hint = new JPanel();
		hint.setBackground(Color.green);
		hint.add(label);
		hint.setBorder(new TitledBorder("Hint"));
		this.add(hint, BorderLayout.NORTH);
		input = new JTextField(10);
		input.addKeyListener(this);
		enter = new JButton("Enter");
		enter.addActionListener(listener);
		giveup = new JButton("Give Up");
		giveup.addActionListener(listener2);
		retry = new JButton("Retry");
		retry.addActionListener(listener3);
		retry.setVisible(false);
		center = new JPanel();
		center.setBackground(Color.yellow);
		center.add(new JLabel("Enter your guess: "));
		center.add(input);
		center.add(enter);
		center.add(giveup);
		this.add(center, BorderLayout.CENTER);
		bottom = new JPanel();
		usedGuess = new JLabel(" You used 0 guess.");
		bottom.add(usedGuess, BorderLayout.SOUTH);
		bottom.add(retry, BorderLayout.SOUTH);
		this.add(bottom, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);

	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int inputNum = Integer.parseInt(input.getText());
			boolean checking = game.guess(inputNum);

			if (checking == true) {
				retry.setVisible(true);
				giveup.setEnabled(false);
				input.setEnabled(false);
				enter.setEnabled(false);
				label.setText(game.getHint() + ".");
				usedGuess.setText("You used " + game.getCount() + " guesses.");
				label.setForeground(Color.RED);
				usedGuess.setForeground(Color.RED);
			} else {
				retry.setVisible(false);
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
			retry.setVisible(true);
			input.setEnabled(false);
			enter.setEnabled(false);

		}

	}

	class Retry implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.secret = game.getRandomNumber(game.upperBound);
			label.setText("I'm thinking of a number between 1 and " + game.upperBound);
			label.setForeground(Color.black);
			usedGuess.setForeground(Color.BLACK);
			usedGuess.setText("You used 0 guess.");
			input.setEnabled(true);
			enter.setEnabled(true);
			giveup.setEnabled(true);
			retry.setVisible(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int inputNum = Integer.parseInt(input.getText());
			boolean checking = game.guess(inputNum);

			if (checking == true) {
				retry.setVisible(true);
				giveup.setEnabled(false);
				input.setEnabled(false);
				enter.setEnabled(false);
				label.setText(game.getHint() + ".");
				usedGuess.setText("You used " + game.getCount() + " guesses.");
				label.setForeground(Color.RED);
				usedGuess.setForeground(Color.RED);
			} else {
				retry.setVisible(false);
				label.setText(game.getHint());
				usedGuess.setText("You used " + game.getCount() + " guesses.");
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

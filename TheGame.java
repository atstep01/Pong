//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/3/16
//Class - 3rd
//Lab  - APCS

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame
{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 700;

	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);

		Pong game = new Pong();

		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		TheGame run = new TheGame();
	}
}
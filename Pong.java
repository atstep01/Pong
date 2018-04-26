//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/3/2016
//Class - 3rd
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable, Collidable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(400,400,20,20,Color.RED,1,1);

		leftPaddle = new Paddle(80,400,20,100,Color.BLUE,5);

		rightPaddle = new Paddle(1100,400,20,100,Color.BLUE,5);

		leftScore = 0;

		rightScore = 0;

		keys = new boolean[4];

    	setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		//see if ball hits left wall or right wall
		if(!(ball.getX()>= 10 && (ball.getX() + ball.getWidth())<=1180))
		{
			ball.setXSpeed(ball.getXSpeed() * -1);
		}

		//score right
		if(!(ball.getX()>= 10))
		{
				rightScore += 1;
		}

        //score left
        if (!((ball.getX() + ball.getWidth())<=1180))
        {
        		leftScore += 1;
        }

		//see if the ball hits the top or bottom wall
		if(!(ball.getY()>=10 && (ball.getY() + ball.getHeight()) <=660))
		{
			ball.setYSpeed(ball.getYSpeed() * -1);
		}

		//see if the ball hits the left paddle
		if(didCollideLeft(ball))
			{
				if(didCollideUp(ball) || didCollideDown(ball))
					ball.setYSpeed(ball.getYSpeed() * -1);
				else
					ball.setXSpeed(ball.getXSpeed() * -1);
			}

		//see if the ball hits the right paddle
		if(didCollideRight(ball))
			{
				if(didCollideUp(ball) || didCollideDown(ball))
					ball.setYSpeed(ball.getYSpeed() * -1);
				else
					ball.setXSpeed(ball.getXSpeed() * -1);
			}

		//paddle movement
		if(keys[0] == true)
		{
			//move left paddle up
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true)
		{
			//move right up
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			//move right down
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}
	public boolean didCollideLeft(Object obj)
	{
		Ball b = (Ball)obj;
		if((b.getX() <= (leftPaddle.getX() + leftPaddle.getWidth() + b.getXSpeed()))
			&&
			(((b.getY() >= leftPaddle.getY()) && (b.getY() <= (leftPaddle.getY() + leftPaddle.getHeight())))
			||
			((b.getY() + b.getHeight()) >= leftPaddle.getY()) && ((b.getY() + b.getHeight()) <= (leftPaddle.getY() + leftPaddle.getHeight()))))
				return true;
		return false;
	}
    public boolean didCollideRight(Object obj)
    {
    	Ball b = (Ball)obj;
    	if(((b.getX() +b.getWidth()) >= (rightPaddle.getX() - b.getXSpeed()))
			&&
			(((b.getY() >= rightPaddle.getY()) && (b.getY() <= (rightPaddle.getY() + rightPaddle.getHeight())))
			||
			((b.getY() + b.getHeight()) >= rightPaddle.getY()) && ((b.getY() + b.getHeight()) <= (rightPaddle.getY() + rightPaddle.getHeight()))))
				return true;
    	return false;
    }
    public boolean didCollideUp(Object obj)
    {
    	Ball b = (Ball)obj;
    	if(didCollideLeft(b) || didCollideRight(b))
    		if(b.getX() >= ((leftPaddle.getX() + leftPaddle.getWidth()) - b.getXSpeed()) || b.getX() >= (rightPaddle.getX() -  b.getXSpeed()) )
    			if((b.getY() + b.getHeight()) <= leftPaddle.getY() || (b.getY() + b.getHeight()) <= rightPaddle.getY() )
    				return true;
    	return false;
    }
    public boolean didCollideDown(Object obj)
    {
    	Ball b = (Ball)obj;
    	if(didCollideLeft(b) || didCollideRight(b))
    		if(b.getX() >= ((leftPaddle.getX() + leftPaddle.getWidth()) - b.getXSpeed()) || b.getX() >= (rightPaddle.getX() -  b.getXSpeed()) )
    			if(b.getY()  >= (leftPaddle.getY() +leftPaddle.getHeight()) || b.getY()  >= (rightPaddle.getY() +rightPaddle.getHeight()) )
    				return true;
    	return false;
    }

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'S' : keys[0]=true; break;
			case 'W' : keys[1]=true; break;
			case 'K' : keys[2]=true; break;
			case 'I' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'S' : keys[0]=false; break;
			case 'W' : keys[1]=false; break;
			case 'K' : keys[2]=false; break;
			case 'I' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
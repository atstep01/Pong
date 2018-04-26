//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/2/16
//Class - 3rd
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//ball = new Ball();
		//instantiate a new Ball
		//ball = new Ball(300,300);
		//ball = new Ball(400,400,50,50);
        //ball = new Ball(500,500,30,30,Color.RED);
		ball = new Ball(200,200,40,40,Color.BLACK,10,10);
		//test the Ball thoroughly


		//test all constructors


		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/1/16
//Class - 3rd
//Lab  -Pong

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;
    // Constructors
	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
    public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c, int xSpd, int ySpd)
	{
		super(x,y,w,h,c);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
   // set methods
   public void setXSpeed(int x)
   {
   	xSpeed = x;
   }
   public void setYSpeed(int y)
   {
   	ySpeed = y;
   }
   // get methods
   public int getXSpeed()
   {
   	return xSpeed;
   }
   public int getYSpeed()
   {
   	return ySpeed;
   }
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  this.draw(window,Color.WHITE);

      setX(getX() + xSpeed);
	  setY(getY() + ySpeed);
      //draw the ball at its new location
	  this.draw(window);
   }

	public boolean equals(Object obj)
	{
		Ball two = (Ball) obj;
		if(super.equals(obj))
			if(xSpeed == two.getXSpeed() && ySpeed == two.getYSpeed())
				return true;
		return false;
	}

   //toString
    public String toString()
    {
    	return super.toString() + " " + xSpeed + " " + ySpeed;
    }
}
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/1/2016
//Class - 3rd
//Lab  - Pong
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;
   //constructors
   public Paddle()
   {
	  super(10,10);
      speed =5;
   }
   public Paddle(int x,int y)
   {
      super(x,y);
      speed =5;
   }
   public Paddle(int x,int y,int s)
   {
	  super(x,y);
      speed =s;
   }
   public Paddle(int x, int y, int w, int h, int s)
   {
	  super(x,y,w,h);
      speed =s;
   }
   public Paddle(int x, int y, int w, int h, Color c, int s)
   {
      super(x,y,w,h,c);
      speed = s;
   }
   //set method
   public void setSpeed(int s)
   {
   	speed = s;
   }
   //get method
   public int getSpeed()
   {
   	return speed;
   }
   public void moveUpAndDraw(Graphics window)
   {
	  this.draw(window,Color.WHITE);
      setY(getY() + speed);
	  this.draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
      this.draw(window,Color.WHITE);
      setY(getY() - speed);
	  this.draw(window);
   }
   //toString()
   public String toString()
   {
   	return super.toString() + " " + speed;
   }

}
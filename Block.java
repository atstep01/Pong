//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/1/2016
//Class - 3rd
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;
	//constructors
	public Block()
	{
		xPos = 400;
		yPos = 300;
		width = 10;
		height = 10;
		color = Color.BLUE;
	}
	public Block(int x, int y)
	{
		xPos = x;
		yPos = x;
		width = 10;
		height = 10;
		color = Color.BLUE;
	}
	public Block(int x, int y, int w, int h)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLUE;
	}
	public Block(int x, int y, int w, int h, Color c)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}
	//set methods
	public void setPos( int x, int y)
	{
		xPos = x;
		yPos = y;
	}
    public void setX( int x )
    {
    	xPos = x;
    }
    public void setY( int y )
    {
    	yPos = y;
    }
    public void setSize(int w, int h)
    {
    	width = w;
    	height = h;
    }
	public void setWidth(int w)
	{
		width = w;
	}
	public void setHeight(int h)
	{
		height = h;
	}

   public void setColor(Color c)
   {
   	color = c;
   }
	//get methods
	public int getX()
	{
		return xPos;
	}
    public int getY()
    {
    	return yPos;
    }
    public int getWidth()
    {
    	return width;
    }
    public int getHeight()
    {
    	return height;
    }
    public Color getColor()
    {
    	return color;
    }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	 window.setColor(col);
     window.fillRect(getX(), getY(), getWidth(), getHeight());

   }

	public boolean equals(Object obj)
	{
		Block two = (Block) obj;
		if(xPos == two.getX() && yPos == two.getY())
			if(width == two.getWidth() && height == two.getHeight())
				if(color == two.getColor())
					return true;
		return false;
	}
   //toString
   public String toString()
   {
   	return xPos + " " + yPos + " " + width + " " + height + " " + color.toString();
   }

}
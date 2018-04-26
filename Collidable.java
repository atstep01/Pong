//© A+ Computer Science  -  www.apluscompsci.com
//Name - Austin Stephens
//Date - 3/1/2016
//Class - 3rd
//Lab  - Pong


public interface Collidable
{
   boolean didCollideLeft(Object obj);
   boolean didCollideRight(Object obj);
   boolean didCollideUp(Object obj);
   boolean didCollideDown(Object obj);
}
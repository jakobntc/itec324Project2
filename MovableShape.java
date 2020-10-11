package Project2;

import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MovableShape
{
   /**
      Draws the shape.
      @param g the graphics context
   */
   void draw(Graphics g);
   /**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
   void translate(int dx, int dy);

   String getShapeName();

   int getX();

   int getY();

   int getWidth();

   boolean getMovingUp();

   void setMovingUp(boolean x);

   boolean getMovingRight();

   void setMovingRight(boolean x);

}

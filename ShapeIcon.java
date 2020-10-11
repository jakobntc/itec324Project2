package Project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A ImageIcon being used as a canvas for animation
 */
public class ShapeIcon extends ImageIcon {

   /**
    * The constructor for the ShapeIcon.
    *
    * @param shapes An ArrayList of MovableShapes desired to be drawn.
    * @param width A integer containing the width of the ImageIcon.
    * @param height A integer containing the height of the ImageIcon.
    */
   public ShapeIcon(ArrayList<MovableShape> shapes,
      int width, int height)
   {
      this.shapes = shapes;
      this.width = width;
      this.height = height;
   }

   /**
    * Returns the current width value.
    *
    * @return A integer containing the width of the ImageIcon
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    * Returns the current height value.
    *
    * @return A integer containing the height of the ImageIcon
    */
   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;

      for (MovableShape ms : shapes) {
         ms.draw(g2);
      }
   }

   private int width;
   private int height;
   private ArrayList<MovableShape> shapes;

}



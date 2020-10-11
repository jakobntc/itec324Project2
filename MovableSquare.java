package Project2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * This class MovableSquare is used to create a MovableShape which is drawable and translatable.
 */
public class MovableSquare implements MovableShape {

    private int x;
    private int y;
    private int width;
    private boolean forward;
    private boolean up;

    /**
     * The constructor for the MovableSquare class. Random values are being assigned to the x and y values, as well as
     * the movingRight and movingUp fields.
     *
     * @param width The desired width of the shape.
     */
    public MovableSquare(int width) {
        int minXY = 0;
        int maxXY = 400;
        int range = maxXY - minXY + 1;

        int randomBooleanMin = 0;
        int randomBooleanMax = 1;
        int randomBooleanRange = randomBooleanMax - randomBooleanMin + 1;

        int random = (int) (Math.random() * range) + minXY;
        this.x = random;
        random = (int) (Math.random() * range) + minXY;
        this.y = random;

        int randomBoolean1 = (int) (Math.random() * randomBooleanRange) + randomBooleanMin;
        int randomBoolean2 = (int) (Math.random() * randomBooleanRange) + randomBooleanMin;

        if(randomBoolean1 == 0 && randomBoolean2 == 0) {
            this.forward = false;
            this.up = false;
        } else if (randomBoolean1 == 1 && randomBoolean2 == 1) {
            this.forward = true;
            this.up = true;
        } else if (randomBoolean1 == 0 && randomBoolean2 == 1) {
            this.forward = false;
            this.up = true;
        } else if (randomBoolean1 == 1 && randomBoolean2 == 0) {
            this.forward = true;
            this.up = false;
        }
        this.width = width;
    }

    /**
     * Draws a instance of the shape on a canvas.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, width);
        g2.setColor(Color.blue);
        g2.fill(rectangle);

        Ellipse2D.Double circle = new Ellipse2D.Double(x + width/4, y + width/4, width/2, width/2);
        g2.setColor(Color.black);
        g2.fill(circle);
    }

    /**
     * Moves the shape across the screen using the x and y values.
     *
     * @param dx the amount to translate in x-direction
     * @param dy the amount to translate in y-direction
     */
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Returns a String containing the shape name.
     *
     * @return A String with the shape name.
     */
    public String getShapeName() { return "MovableSquare"; }

    /**
     * Returns the x value of the current shape.
     *
     * @return An integer containing this x value.
     */
    public int getX() {
        int copy = this.x;
        return copy;
    }

    /**
     * Returns the y value of the current shape.
     *
     * @return An integer containing this y value.
     */
    public int getY() {
        int copy = this.y;
        return copy;
    }

    /**
     * Returns the width value of the current shape.
     *
     * @return An integer containing this width value.
     */
    public int getWidth() {
        int copy = this.width;
        return copy;
    }

    /**
     * Returns the boolean value determining if the shape is moving right or not of the current shape.
     *
     * @return An boolean containing this movingRight value.
     */
    public boolean getMovingRight() { return this.forward; }

    /**
     * Sets the current shape's movingForward value to the provided boolean.
     *
     * @param x True if shape's x value is positive, otherwise false.
     */
    public void setMovingRight(boolean x) { this.forward = x; }

    /**
     * Returns the boolean value determining if the shape is moving up or not of the current shape.
     *
     * @return An boolean containing this up value.
     */
    public boolean getMovingUp() { return this.up; }

    /**
     * Sets the current shape's movingUp value to the provided boolean.
     *
     * @param x True if shape's y value is positive, otherwise false.
     */
    public void setMovingUp(boolean x) { this.up = x; }


}

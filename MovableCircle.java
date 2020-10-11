package Project2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * This class MovableCircle is used to create a MovableShape which is drawable and translatable.
 */
public class MovableCircle implements MovableShape {

    private int x;
    private int y;
    private int width;
    private boolean movingRight;
    private boolean movingUp;

    /**
     * The constructor for the MovableCircle class. Random values are being assigned to the x and y values, as well as
     * the movingRight and movingUp fields.
     *
     * @param width The desired width of the shape.
     */
    public MovableCircle(int width) {
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
            this.movingRight = false;
            this.movingUp = false;
        } else if (randomBoolean1 == 1 && randomBoolean2 == 1) {
            this.movingRight = true;
            this.movingUp = true;
        } else if (randomBoolean1 == 0 && randomBoolean2 == 1) {
            this.movingRight = false;
            this.movingUp = true;
        } else if (randomBoolean1 == 1 && randomBoolean2 == 0) {
            this.movingRight = true;
            this.movingUp = false;
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

        Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, this.width, this.width);
        g2.setColor(Color.black);
        g2.fill(circle);

        Rectangle2D.Double square = new Rectangle2D.Double(this.x + width/4, this.y + width/4, this.width/2, this.width/2);
        g2.setColor(Color.green);
        g2.fill(square);
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
    public String getShapeName() { return "MovableCircle"; }

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
     * Returns the boolean value determining if the shape is moving up or not of the current shape.
     *
     * @return An boolean containing this up value.
     */
    public boolean getMovingUp() { return this.movingUp; }

    /**
     * Sets the current shape's movingUp value to the provided boolean.
     *
     * @param x True if shape's y value is positive, otherwise false.
     */
    public void setMovingUp(boolean x) { this.movingUp = x; }

    /**
     * Returns the boolean value determining if the shape is moving right or not of the current shape.
     *
     * @return An boolean containing this movingRight value.
     */
    public boolean getMovingRight() { return this.movingRight; }

    /**
     * Sets the current shape's movingForward value to the provided boolean.
     *
     * @param x True if shape's x value is positive, otherwise false.
     */
    public void setMovingRight(boolean x) { this.movingRight = x; }

}

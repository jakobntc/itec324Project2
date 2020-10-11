package Project2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class MovableLogo is used to create a MovableShape which is drawable and translatable.
 */
public class MovableLogo implements MovableShape{

    private int x;
    private int y;
    final private int width = 100;
    private boolean up;
    private boolean forward;
    private BufferedImage image;

    /**
     * The constructor for the MovableLogo class. Random values are being assigned to the x and y values, as well as
     * the movingRight and movingUp fields.
     */
    public MovableLogo() {

        try {
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
            BufferedImage newImage = ImageIO.read(getClass().getResource("dvdVideoLogo.png"));

            image = resize(newImage, 100, 100);
        }

        catch(IOException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

    /**
     * Resizes the current BufferedImage to be a desired height and width.
     *
     * @param img The old BufferedImage that is to be resized.
     * @param newW A integer containing the new width.
     * @param newH A integer containing the new height.
     * @return A new BufferedImage that has been resized to the desired dimensions.
     */
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage newImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = newImg.createGraphics();
        g2.drawImage(tmp, 0, 0, null);

        return newImg;
    }

    /**
     * Draws a instance of the image on a canvas.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g) { g.drawImage(image, this.x, this.y, null); }

    /**
     * Moves the shape across the screen using the x and y values.
     *
     * @param dx the amount to translate in x-direction
     * @param dy the amount to translate in y-direction
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Returns a String containing the shape name.
     *
     * @return A String with the shape name.
     */
    public String getShapeName() { return "MovableLogo"; }

    /**
     * Returns the x value of the current shape.
     *
     * @return An integer containing this x value.
     */
    public int getX() { return this.x; }

    /**
     * Returns the y value of the current shape.
     *
     * @return An integer containing this y value.
     */
    public int getY() { return this.y; }

    /**
     * Returns the width value of the current shape.
     *
     * @return An integer containing this width value.
     */
    public int getWidth() { return this.width; }

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
}

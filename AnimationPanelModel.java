package Project2;

import java.util.ArrayList;

/**
 * The AnimationPanelModel class contains fields that can be changed that affect the view. A list of observers is also
 * kept.
 */
public class AnimationPanelModel {

    private boolean animationMoving = true;

    private ArrayList<MovableShape> shapes = new ArrayList<>();
    private ArrayList<ModelObserver> observers = new ArrayList<>();

    /**
     * Adds a ModelObserver to the list of observers.
     *
     * @param mo The observer observing this class.
     */
    public void addObserver(ModelObserver mo) {
        observers.add(mo);
    }

    /**
     * Notifies all observers of any changes to any fields so the correct information can be shown in the view.
     */
    private void notifyObservers() {
        for (ModelObserver mo : observers) {
            mo.notifyOfModelChanges();
        }
    }

    /**
     * Returns a boolean value corresponding with the animation movement.
     *
     * @return True if the animation is un-paused. False if the animation is paused.
     */
    public boolean isAnimationMoving() {
        return animationMoving;
    }

    /**
     * Sets the animationMoving field to reflect the current animation and then notifies all observers.
     *
     * @param animationMovingBoolean True if animation is un-paused. False if the animation is paused.
     */
    public void setAnimationMoving(boolean animationMovingBoolean) {
        this.animationMoving = animationMovingBoolean;
        notifyObservers();
    }

    /**
     * Adds a MovableSquare object to the list of MovableShapes and then notifies all observers.
     */
    public void addShape1() {
        MovableShape shape = new MovableSquare(100);
        addShape(shape);
        notifyObservers();
    }

    /**
     * Adds a MovableCircle object to the list of MovableShapes and then notifies all observers.
     */
    public void addShape2() {
        MovableCircle shape = new MovableCircle(100);
        addShape(shape);
        notifyObservers();
    }

    /**
     * Adds a MovableLogo object to the list of MovableShapes and then notifies all observers.
     */
    public void addShape3() {
        MovableLogo logo = new MovableLogo();
        addShape(logo);
        notifyObservers();
    }

    /**
     * Adds a shape to the ArrayList of MovableShapes.
     *
     * @param shape The shape to add to the ArrayList.
     */
    public void addShape(MovableShape shape) { shapes.add(shape); }

    public ArrayList<MovableShape> getShapes() {
        ArrayList<MovableShape> copy = this.shapes;
        return copy;
    }

    /**
     * Sets the ArrayList to a new ArrayList of MovableShapes.
     *
     * @param shapes The new ArrayList to be assigned to the shapes field.
     */
    public void setShapes(ArrayList<MovableShape> shapes) {
        this.shapes = shapes;
        notifyObservers();
    }

}

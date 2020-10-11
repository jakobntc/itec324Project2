package Project2;

import java.util.ArrayList;

/**
 * The ButtonPanelModel class contains fields that can be changed that affect the view. A list of observers is also
 * kept.
 */
public class ButtonPanelModel {

    private boolean animationShowing = false;
    private boolean shape1CheckBoxIsChecked = false;
    private boolean shape2CheckBoxIsChecked = false;
    private boolean shape3CheckBoxIsChecked = false;

    private ArrayList<ModelObserver> observers = new ArrayList<>();

    /**
     * Adds a ModelObserver to the ArrayList of observers.
     *
     * @param mo The ModelObserver to be added to the ArrayList.
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
     * Returns the boolean value corresponding with the animationShowing field.
     *
     * @return True if the AnimationPanelView is visible. False if the AnimationPanelView is invisible.
     */
    public boolean isAnimationShowing() {
        return animationShowing;
    }

    /**
     * Sets the animationShowing field to the desired boolean value and then notifies all observers.
     *
     * @param animationShowing True if the AnimationPanelView is visible. False if the AnimationPanelView is invisible.
     */
    public void setAnimationShowing(boolean animationShowing) {
        this.animationShowing = animationShowing;
        notifyObservers();
    }

    /**
     * Returns the boolean value corresponding with the shape1CheckBox.
     *
     * @return True if the JCheckBox is checked, otherwise false.
     */
    public boolean isShape1CheckBoxChecked() {
        return shape1CheckBoxIsChecked;
    }

    /**
     * Sets the shape1CheckBoxIsChecked field to the provided value and then notifies all observers.
     *
     * @param shape1CheckBoxIsChecked True if the JCheckBox is checked, otherwise false.
     */
    public void setShape1CheckBoxIsChecked(boolean shape1CheckBoxIsChecked) {
        this.shape1CheckBoxIsChecked = shape1CheckBoxIsChecked;
        notifyObservers();
    }

    /**
     * Returns the boolean value corresponding with the shape2CheckBox.
     *
     * @return True if the JCheckBox is checked, otherwise false.
     */
    public boolean isShape2CheckBoxChecked() { return shape2CheckBoxIsChecked; }

    /**
     * Sets the shape2CheckBoxIsChecked field to the provided value and then notifies all observers.
     *
     * @param shape2CheckBoxIsChecked True if the JCheckBox is checked, otherwise false.
     */
    public void setShape2CheckBoxIsChecked(boolean shape2CheckBoxIsChecked) {
        this.shape2CheckBoxIsChecked = shape2CheckBoxIsChecked;
        notifyObservers();
    }

    /**
     * Returns the boolean value corresponding with the shape3CheckBox.
     *
     * @return True if the JCheckBox is checked, otherwise false.
     */
    public boolean isShape3CheckBoxChecked() {
        return shape3CheckBoxIsChecked;
    }

    /**
     * Sets the shape3CheckBoxIsChecked field to the provided value and then notifies all observers.
     *
     * @param shape3CheckBoxIsChecked True if the JCheckBox is checked, otherwise false.
     */
    public void setShape3CheckBoxIsChecked(boolean shape3CheckBoxIsChecked) {
        this.shape3CheckBoxIsChecked = shape3CheckBoxIsChecked;
        notifyObservers();
    }

}

package Project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The AnimationPanelView holds all components to be used in the animation panel.
 */
public class AnimationPanelView extends JPanel implements ModelObserver {

    private JPanel animationWindow;
    private JLabel animationLabel;
    private ShapeIcon animationIcon;

    private JButton pauseButton;
    private JButton hideButton;

    private AnimationPanelModel model;

    private MovableShape shape1 = new MovableLogo();

    /**
     * Constructor for a AnimationPanelView. Adds this class to be an observer of the provided model.
     *
     * @param model The AnimationPanelModel containing the data for this AnimationPanelView.
     */
    public AnimationPanelView(AnimationPanelModel model) {

        this.model = model;

        model.addShape(shape1);
        animationIcon = new ShapeIcon(model.getShapes(),600,500);
        animationLabel = new JLabel(animationIcon);
        animationWindow = new JPanel();
        notifyOfModelChanges();

        pauseButton = new JButton("Pause");
        hideButton = new JButton("Hide");

        animationWindow.add(animationLabel);

        model.addObserver(this);

        this.add(animationWindow);
        this.add(pauseButton);
        this.add(hideButton);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
    }

    /**
     * Updates the view to reflect the data in the AnimationPanelModel.
     */
    @Override
    public void notifyOfModelChanges() {
        updateShapes();
        animationLabel.repaint();
        animationWindow.repaint();
    }

    /**
     * Creates a new ShapeIcon containing the current ArrayList of MovableShapes.
     */
    private void updateShapes() {
        ArrayList<MovableShape> shapes = model.getShapes();
        animationLabel.setIcon(new  ShapeIcon(shapes, 600,500));
    }

    /**
     * Returns the JButton affiliated with the 'Pause' button.
     *
     * @return The JButton affiliated with the 'Pause' button.
     */
    public JButton getPauseButton() {
        return pauseButton;
    }

    /**
     * Returns the JButton affiliated with the 'Hide' button.
     *
     * @return The JButton affiliated with the 'Hide' button.
     */
    public JButton getHideButton() {
        return hideButton;
    }

    /**
     * Returns the JPanel where all of the animations are being displayed
     *
     * @return The JPanel where all of the animations are being displayed
     */
    public JPanel getAnimationWindow() {
        JPanel copy = animationWindow;
        return copy;
    }

    /**
     * Returns the ShapeIcon where all of the animations are being displayed
     *
     * @return The ShapeIcon where all of the animations are being displayed
     */
    public Icon getAnimationIcon() {
        Icon copy = animationIcon;
        return copy;
    }

}

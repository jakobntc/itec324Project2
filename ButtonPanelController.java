package Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ButtonPanelController class adds functionality to the JButtons and JCheckBox's located in the ButtonPanelView.
 */
public class ButtonPanelController {

    ButtonPanelModel buttonModel;
    ButtonPanelView buttonView;
    AnimationPanelView animationView;
    AnimationPanelModel animationModel;
    JFrame mainFrame;

    /**
     * Creates a ButtonPanelController object. Functionality for all Components located in the ButtonPanelView are also
     * being implemented.
     *
     * @param model The ButtonPanelModel containing the data for the view.
     * @param view The ButtonPanelView containing the Components that need functionality.
     * @param animationView The AnimationPanelView; used to set visibility.
     * @param animationModel The AnimationPanelModel; used to access data about the AnimationPanelView.
     * @param mainFrame The JFrame where all Components are being added.
     */
    public ButtonPanelController(ButtonPanelModel model, ButtonPanelView view,
                                 AnimationPanelView animationView, AnimationPanelModel animationModel,
                                 JFrame mainFrame) {

        this.buttonModel = model;
        this.buttonView = view;
        this.animationView = animationView;
        this.animationModel = animationModel;
        this.mainFrame = mainFrame;

        this.buttonView.getShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimationWindow();
            }
        });

        this.buttonView.getShape1CheckBox().addActionListener(actionEvent -> {
            this.buttonModel.setShape1CheckBoxIsChecked(buttonView.getShape1CheckBox().isSelected());
        });

        this.buttonView.getShape2CheckBox().addActionListener(actionEven -> {
            this.buttonModel.setShape2CheckBoxIsChecked(buttonView.getShape2CheckBox().isSelected());
        });

        this.buttonView.getShape3CheckBox().addActionListener(actionEvent -> {
            this.buttonModel.setShape3CheckBoxIsChecked(buttonView.getShape3CheckBox().isSelected());
        });

        this.buttonView.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAnimation();
            }
        });

        this.buttonView.getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitAnimation();
            }
        });

        this.buttonView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShapes();
            }
        });

    }

    /**
     * This method sets the AnimationPanelView to be visible if the ButtonPanelModel field for visibility is false.
     */
    public void addAnimationWindow() {
        if (!buttonModel.isAnimationShowing()) {
            animationView.setVisible(true);
            buttonModel.setAnimationShowing(true);
            mainFrame.pack();
            animationModel.setAnimationMoving(true);

        }
    }

    /**
     * Adds a shape to the ArrayList contained in the AnimationModel class depending on which JCheckBox's are checked.
     */
    public void addShapes() {
        if (buttonModel.isShape1CheckBoxChecked() &&
                buttonModel.isShape2CheckBoxChecked() &&
                buttonModel.isShape3CheckBoxChecked()
        ) {
            animationModel.addShape1();
            animationModel.addShape2();
            animationModel.addShape3();
        } else if (buttonModel.isShape1CheckBoxChecked() &&
                buttonModel.isShape2CheckBoxChecked()
        ) {
            animationModel.addShape1();
            animationModel.addShape2();
        } else if (buttonModel.isShape1CheckBoxChecked() &&
                buttonModel.isShape3CheckBoxChecked()
        ) {
            animationModel.addShape1();
            animationModel.addShape3();
        } else if (buttonModel.isShape2CheckBoxChecked() &&
                buttonModel.isShape3CheckBoxChecked()
        ) {
            animationModel.addShape1();
            animationModel.addShape3();
        } else if (buttonModel.isShape1CheckBoxChecked()) {
            animationModel.addShape1();
        } else if (buttonModel.isShape2CheckBoxChecked()) {
            animationModel.addShape2();
        } else if (buttonModel.isShape3CheckBoxChecked()) {
            animationModel.addShape3();
        }
    }

    /**
     * Quits the program.
     */
    public void quitAnimation() { System.exit(1); }

    /**
     * Creates an empty ArrayList of MovableShapes, then sets the current ArrayList in the AnimationPanelModel to be the
     * empty one.
     */
    public void resetAnimation() {
        ArrayList<MovableShape> shapes = new ArrayList<>();
        animationModel.setShapes(shapes);
    }

}

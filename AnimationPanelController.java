package Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The AnimationPanelController class adds functionality to the JButtons located in the AnimationPanelView.
 */
public class AnimationPanelController {

    private AnimationPanelModel model;
    private AnimationPanelView view;
    private ButtonPanelModel buttonModel;
    private ButtonPanelView buttonView;
    private JFrame mainFrame;

    private final int TIMER_DELAY = 10;
    private Timer t;

    /** Constructor for a AnimationPanelController object, the Timer used to move shapes is being created automatically.
     * All component action listeners are also being defined.
     *
     * @param model The AnimationPanelModel containing the data needed for the AnimationPanelView.
     * @param view The AnimationPanelView containing the components the AnimationPanelController will be giving
     *             functionality to.
     * @param buttonModel The ButtonPanelModel used for showing the AnimationPanelView.
     * @param mainFrame The frame that the components are being added to.
     */
    public AnimationPanelController(AnimationPanelModel model, AnimationPanelView view,
                                    ButtonPanelModel buttonModel, ButtonPanelView buttonView, JFrame mainFrame) {
        this.model = model;
        this.view = view;
        this.mainFrame = mainFrame;
        this.buttonModel = buttonModel;
        this.buttonView = buttonView;

        t = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<MovableShape> shapes = model.getShapes();

                for (MovableShape ms : shapes) {
                    if (ms.getMovingRight() && ms.getMovingUp()) {
                        if ((ms.getX() + ms.getWidth()) >= view.getAnimationIcon().getIconWidth()) {
                            ms.setMovingRight(false);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else if (ms.getY() + ms.getWidth() >= view.getAnimationIcon().getIconHeight()) {
                            ms.setMovingUp(false);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else {
                            ms.translate(1, 1);
                        }
                    } else if (!ms.getMovingRight() && ms.getMovingUp()){
                        if (ms.getX() <= 0) {
                            ms.setMovingRight(true);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else if (ms.getY() + ms.getWidth() >= view.getAnimationIcon().getIconHeight()) {
                            ms.setMovingUp(false);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else {
                            ms.translate(-1, 1);
                        }
                    } else if (ms.getMovingRight() && !ms.getMovingUp()) {
                        if ((ms.getX() + ms.getWidth()) >= view.getAnimationIcon().getIconWidth()) {
                            ms.setMovingRight(false);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else if (ms.getY() <= 0) {
                            ms.setMovingUp(true);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else {
                            ms.translate(1, -1);
                        }
                    } else if (!ms.getMovingRight() && !ms.getMovingUp()) {
                        if (ms.getX() <= 0) {
                            ms.setMovingRight(true);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else if (ms.getY() <= 0) {
                            ms.setMovingUp(true);
                            buttonView.updateTextField("Boing! " + ms.getShapeName() + " just bounced!");
                        } else {
                            ms.translate(-1, -1);
                        }
                    }
                    view.getAnimationWindow().repaint();
                }
            }
        });
        t.start();

        /*
        Giving functionality to the pause button.
         */
        this.view.getPauseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAnimation();
            }
        });

        /*
        Giving functionality to the hide button.
         */
        this.view.getHideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAnimation();
            }
        });

    }

    /**
     * This method stops and starts the timer.
     */
    public void handleAnimation() {
        if (model.isAnimationMoving()) {
            t.stop();
            model.setAnimationMoving(false);
        }else {
            t.start();
            model.setAnimationMoving(true);
        }
    }

    /**
     * This method sets the AnimationPanelView to be invisible if the ButtonPanelModel field for visibility is true.
     */
    public void hideAnimation() {
        if (buttonModel.isAnimationShowing()) {
            view.setVisible(false);
            mainFrame.pack();
            mainFrame.repaint();
            buttonModel.setAnimationShowing(false);
        }
    }

}

package Project2;

import javax.swing.*;
import java.awt.*;

/**
 * Driver for the animation of this program.
 */
public class MultiShapeDriver
{

   private JFrame frame = new JFrame("Project 2 Demo");

   private AnimationPanelController animationController;
   private AnimationPanelModel animationModel;
   private AnimationPanelView animationView;

   private ButtonPanelController buttonController;
   private ButtonPanelModel buttonModel;
   private ButtonPanelView buttonView;

   public static void main(String[] args) { new MultiShapeDriver(); }

   /**
    * Driver for the animation of this program.
    */
   public MultiShapeDriver() {

      animationModel = new AnimationPanelModel();
      animationView = new AnimationPanelView(animationModel);


      buttonModel = new ButtonPanelModel();
      buttonView = new ButtonPanelView(buttonModel);

      animationController = new AnimationPanelController(animationModel, animationView, buttonModel, buttonView, frame);
      buttonController = new ButtonPanelController(buttonModel, buttonView, animationView, animationModel, frame);

      frame.add(buttonView);
      frame.add(animationView);
      animationView.setVisible(false);

      FlowLayout layout = new FlowLayout();
      frame.setLayout(layout);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

   }
}
MultiShapeDriver runs the program.

AnimationPanelModel houses data about AnimationPanelView that can be changed.
    this class also contains a list of Observers.

AnimationPanelView contains all of the components and displays them to the
    user.

AnimationPanelController contains both a AnimationPanelModel, and a
    AnimationPanelView. This class gives functionality to all of the
    components in the AnimationPanelView.

ButtonPanelModel houses data about ButtonPanelModel that can be changed.
    this class also contains a list of Observers.

ButtonPanelView contains all of the components and displays them to the user.

ButtonPanelController contains both a ButtonPanelModel, and a ButtonPanelView.
    This class gives functionality to all of the components in the
    ButtonPanelView.

ModelObserver is a interface that defines what a modelObserver object should
    contain.

MovableShape is a interface that defines what a MoveableShape object should
    contain.

MovableCircle is used to create circle shapes and draw / traslate them across
    screen. This class implements MovableShape.

MovableSquare is used to create square shapes and draw / traslate them across
    screen. This class implements MovableShape.

MovableLogo is used to create a BufferedImage and draw the graphic across the
    screen. This class implements MovableShape.

ShapeIcon is a class that extends Icon. This class contains a ArrayList of
    MovableShapes and prints them out.


    This project was very time consuming. I feel as though if I hadn't started so early I would not have been able to finish. Although, I am very proud of the fact that I was able to paint a BufferedImage onto the screen.

    The hardest part of this project was probably getting the shapes to appear on the ImageIcon, I had to use a ArrayList but I couldn't figure out how to set it up for the longest time.

    I still don't understand testing with JUnit at all so my code is lacking those features. I would really like to talk about it after this exam if that is an option.








package Project2;

import javax.swing.*;

/**
 * The ButtonPanelView holds all components to be used in the button panel.
 */
public class ButtonPanelView extends JPanel implements ModelObserver{

    private JButton showButton;
    private JButton addButton;
    private JButton resetButton;
    private JButton quitButton;

    private JCheckBox shape1CheckBox;
    private JCheckBox shape2CheckBox;
    private JCheckBox shape3CheckBox;

    private JTextField textField;

    private ButtonPanelModel model;

    /**
     * Constructor for a ButtonPanelModel. Adds this class to be an observer of the provided model.
     *
     * @param model The ButtonPanelModel containing the data for this ButtonPanelView.
     */
    public ButtonPanelView(ButtonPanelModel model) {
        this.model = model;

        showButton = new JButton("Show");
        addButton = new JButton("Add");
        resetButton = new JButton("Reset");
        quitButton = new JButton("Quit");

        shape1CheckBox = new JCheckBox("Square Shape");
        shape2CheckBox = new JCheckBox("Circle Shape");
        shape3CheckBox = new JCheckBox("DVD Logo");

        textField = new JTextField(20);

        model.addObserver(this);

        this.add(showButton);

        this.add(shape1CheckBox);
        this.add(shape2CheckBox);
        this.add(shape3CheckBox);

        this.add(addButton);
        this.add(textField);
        this.add(resetButton);
        this.add(quitButton);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
    }

    /**
     * Updates the view to reflect the data in the ButtonPanelModel.
     */
    @Override
    public void notifyOfModelChanges() { this.repaint(); }

    /**
     * Updates the JTextField to the string that is passed in.
     *
     * @param string Desired text to output.
     */
    public void updateTextField(String string) {
        this.textField.setText(string);
    }

    /**
     * Returns the JButton affiliated with the 'Show' button.
     *
     * @return The JButton affiliated with the 'Show' button.
     */
    public JButton getShowButton() {
        return showButton;
    }

    /**
     * Returns the JButton affiliated with the 'Add' button.
     *
     * @return The JButton affiliated with the 'Add' button.
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * Returns the JButton affiliated with the 'Reset' button.
     *
     * @return The JButton affiliated with the 'Reset' button.
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * Returns the JButton affiliated with the 'Quit' button.
     *
     * @return The JButton affiliated with the 'Quit' button.
     */
    public JButton getQuitButton() {
        return quitButton;
    }

    /**
     * Returns the JCheckBox affiliated with the 'Shape1CheckBox' button.
     *
     * @return The JCheckBox affiliated with the 'Shape1CheckBox' button.
     */
    public JCheckBox getShape1CheckBox() {
        return shape1CheckBox;
    }

    /**
     * Returns the JCheckBox affiliated with the 'Shape2CheckBox' button.
     *
     * @return The JCheckBox affiliated with the 'Shape2CheckBox' button.
     */
    public JCheckBox getShape2CheckBox() {
        return shape2CheckBox;
    }

    /**
     * Returns the JCheckBox affiliated with the 'Shape3CheckBox' button.
     *
     * @return The JCheckBox affiliated with the 'Shape3CheckBox' button.
     */
    public JCheckBox getShape3CheckBox() {
        return shape3CheckBox;
    }
}

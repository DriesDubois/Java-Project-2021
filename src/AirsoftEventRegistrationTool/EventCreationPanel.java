package AirsoftEventRegistrationTool;

import javax.swing.*;

public class EventCreationPanel {
    private JTextField EventCreationFormEventNameTextField;
    private JTextField EventCreationFormEventOrganiserTextField;
    private JTextField EventCreationFormEventLocationTextField;
    private JTextField EventCreationFormEventTempTextField;
    private JButton EventCreationFormSubmitButton;
    private JPanel EventCreationPanel;

    public void run() {
        JFrame frame = new JFrame();

        frame.setContentPane(EventCreationPanel);
        frame.setTitle("Creating event");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

package AirsoftEventRegistrationTool;

import javax.swing.*;

public class EventAdminPanel {
    private JLabel eventNameLabel;
    private JLabel eventParticipantsLabel;
    private JList participantsList;
    private JPanel eventAdminPanel;
    private JTextField participantNameTextField;
    private JTextField participantSurnameTextField;
    private JButton registerNewParticipantButton;
    private JFrame EventAdminPanelFrame;



    public void run() {
        JFrame frame = new JFrame();

        frame.setContentPane(eventAdminPanel);
        frame.setTitle("Event administration");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}

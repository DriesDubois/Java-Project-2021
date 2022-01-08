package AirsoftEventRegistrationTool;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class EventAdminPanel {
    private JLabel eventNameLabel;
    private JLabel eventParticipantsLabel;
    private JList playerList;
    private JPanel eventAdminPanel;
    private JTextField participantNameTextField;
    private JTextField participantSurnameTextField;
    private JButton registerNewParticipantButton;
    private JFrame EventAdminPanelFrame;
    private Event event;

    private DefaultListModel <String> playerListPreview = new DefaultListModel<>();

    public EventAdminPanel(Event event) {
        this.event = event;
    }

    public void run() {
        JFrame frame = new JFrame();
        System.out.println(event);
        frame.setContentPane(eventAdminPanel);
        frame.setTitle("Event administration");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        eventNameLabel.setText(this.event.getName());
        eventParticipantsLabel.setText(Integer.toString((event.calculateTotalParticipants())));
        // Make sure that list shows all players involved in the event on startup
        for(Player p: event.getPlayerlist()){
            playerListPreview.addElement(p.getName() + " " + p.getSurname() + " ");
        }

    }
}

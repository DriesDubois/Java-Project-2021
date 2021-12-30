package AirsoftEventRegistrationTool;

import AirsoftEventRegistrationTool.EventCreationPanel;
import AirsoftEventRegistrationTool.EventList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPanel {

    private JPanel RegistrationPanel;
    private JLabel airsoftEventRegistrationToolLabel;
    private JList RegistrationFormListBox;
    private JButton RegistrationFormAddEventButton;


    private DefaultListModel <String> eventListPreview = new DefaultListModel<>();
    private EventList eventList = new EventList();

    public RegistrationPanel() {

        RegistrationFormListBox.setModel(eventListPreview);

        RegistrationFormAddEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventCreationPanel eventCreationPanel = new EventCreationPanel();
                eventCreationPanel.run();
            }
        });


    }

    public void run() {
        JFrame frame = new JFrame();

        frame.setContentPane(RegistrationPanel);
        frame.setTitle("Airsoft event tool");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

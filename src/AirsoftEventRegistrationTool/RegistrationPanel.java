package AirsoftEventRegistrationTool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class RegistrationPanel {

    private JPanel RegistrationPanel;
    private JLabel airsoftEventRegistrationToolLabel;
    private JList RegistrationFormListBox;
    private JButton createEventButton;
    private JTextField eventNameTextField;
    private JTextField eventOrganiserTextField;
    private JTextField eventLocationTextField;
    private JTextField textField1;
    private JButton RegistrationFormAddEventButton;



    private DefaultListModel <String> eventListPreview = new DefaultListModel<>();
    private EventList eventList = new EventList();

    public RegistrationPanel() {

        RegistrationFormListBox.setModel(eventListPreview);


        createEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventname = eventNameTextField.getText();
                String eventlocation =eventLocationTextField.getText();
                String eventorganiser = eventOrganiserTextField.getText();
                LocalDate date = LocalDate.now();
                Event event = new Event(eventname,eventorganiser,eventlocation, date);
                eventList.AddEventToList(event);
                eventListPreview.removeAllElements();
                for(Event eventloopitem : eventList.getEventList() ){
                    eventListPreview.addElement(eventloopitem.getName() + " " + eventloopitem.getNumberOfParticipants() + " " + eventloopitem.getDate());
                }
            }
        });
        RegistrationFormListBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);



                    EventAdminPanel eventAdminPanel = new EventAdminPanel();
                    eventAdminPanel.run();


            }
        });
    }

    public void updateList (Event e){

        eventListPreview.addElement(e.getName() + " " + e.getLocation() + " " + e.getHost() + " " + e.getNumberOfParticipants());
    }

    public void run() {
        JFrame frame = new JFrame();

        frame.setContentPane(RegistrationPanel);
        frame.setTitle("Airsoft event tool");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}

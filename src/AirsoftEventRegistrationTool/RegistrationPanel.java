package AirsoftEventRegistrationTool;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private EventList eventList;



    public RegistrationPanel() {

        RegistrationFormListBox.setModel(eventListPreview);


        createEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventID = Integer.toString((eventList.getEventList().size()+1));
                String eventname = eventNameTextField.getText();
                String eventlocation =eventLocationTextField.getText();
                String eventorganiser = eventOrganiserTextField.getText();
                LocalDate date = LocalDate.now();
                Event event = new Event(eventID, eventname,eventorganiser,eventlocation, date);
                eventList.UpdateOrAddEvent(event);
                eventListPreview.removeAllElements();
                for(Event eventloopitem : eventList.getEventList().values() ){
                    eventListPreview.addElement(eventloopitem.getEventID() + " " +  eventloopitem.getName() + " " + eventloopitem.getNumberOfParticipants() + " " + eventloopitem.getDate());
                }
            }
        });

        RegistrationFormListBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                    String selected = RegistrationFormListBox.getSelectedValue().toString();
                    String selection[] = selected.split(" ");
                System.out.println(selection[0]);
                    Event eventselected = eventList.selectEvent(selection[0]);
                    EventAdminPanel eventAdminPanel = new EventAdminPanel(eventselected);
                    eventAdminPanel.run();
            }
        });
    }

    public void updateList (Event e){

        eventListPreview.addElement(e.getName() + " " + e.getLocation() + " " + e.getHost() + " " + e.getNumberOfParticipants());
    }

    public void run() {
        JFrame frame = new JFrame();
        eventList=CSVReaderWriter.readEvents(new File("files/events.csv"));
        for(Event eventloopitem : eventList.getEventList().values() ){
            eventListPreview.addElement(eventloopitem.getEventID() + " " + eventloopitem.getName() + " " + eventloopitem.getNumberOfParticipants() + " " + eventloopitem.getDate());
        }
        frame.setContentPane(RegistrationPanel);
        frame.setTitle("Airsoft event tool");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}

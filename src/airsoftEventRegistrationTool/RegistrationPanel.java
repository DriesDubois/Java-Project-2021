package airsoftEventRegistrationTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationPanel {

    private JPanel RegistrationPanel;
    private JLabel airsoftEventRegistrationToolLabel;
    private JList RegistrationFormListBox;
    private JButton createEventButton;
    private JTextField eventNameTextField;
    private JTextField eventOrganiserTextField;
    private JTextField eventLocationTextField;
    private JTextField eventPriceTextField;
    private JButton adminEditEventButton;
    private JButton adminEventPanelPrintAllEventsButton;
    private JTextField eventDateTextField;
    private JButton adminDeleteEventButton;
    private JLabel registrationPanelValidationLabel;
    private JButton RegistrationFormAddEventButton;

    private DefaultListModel <String> eventListPreview = new DefaultListModel<>();
    private AirsoftRegistrationTool airsoftRegistrationTool = new AirsoftRegistrationTool();

    public void refreshEvents (){
        eventListPreview.removeAllElements();
        for(Event e : airsoftRegistrationTool.getEventList().getEventMap().values() ){
            eventListPreview.addElement(e.getEventID() + " " +  e.getName() + " " + " " + e.getDate());
        }
    }

    public RegistrationPanel() {

        RegistrationFormListBox.setModel(eventListPreview);



        createEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                boolean inputDateAndPrice = false;
                String eventID = Integer.toString((airsoftRegistrationTool.getEventList().getEventMap().size()+1));
                String eventname = eventNameTextField.getText();
                String eventlocation =eventLocationTextField.getText();
                String eventorganiser = eventOrganiserTextField.getText();
                LocalDate date = null;
                double eventprice =0;

                try{
                    date = LocalDateFormatter.formatDate(eventDateTextField.getText());
                    eventprice = Double.parseDouble(eventPriceTextField.getText());
                    inputDateAndPrice =true;
                } catch (Exception e) {
                    eventDateTextField.setText("Invalid date format or input");

                }


                if(eventname.equals("")||eventlocation.equals("")||eventorganiser.equals("")||!inputDateAndPrice){
                    registrationPanelValidationLabel.setText("Vul alle velden in en check de datum");
                    registrationPanelValidationLabel.setForeground(Color.RED);
                }
                else {
                    Event event = new Event(eventID, eventname,eventorganiser,eventlocation, date , eventprice);
                    event.setPlayerlist(new PlayerList());
                    event.getPlayerlist().setPlayerList(new ArrayList<>());

                    airsoftRegistrationTool.getEventList().AddEvent(event);
                    refreshEvents();
                }
            }
        });

        adminEditEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = RegistrationFormListBox.getSelectedValue().toString();
                String selection[] = selected.split(" ");
                System.out.println(selection[0]);
                Event eventselected =  airsoftRegistrationTool.getEventList().selectEvent(selection[0]);
                if (eventselected.getPlayerlist()==null){
                    eventselected.setPlayerlist(new PlayerList());
                }
                EventAdminPanel eventAdminPanel = new EventAdminPanel(eventselected);
                eventAdminPanel.run();
            }

        });
        adminEventPanelPrintAllEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airsoftRegistrationTool.printAllEvents();
            }
        });
    }


    public void run() {
        JFrame frame = new JFrame();
        frame.setContentPane(RegistrationPanel);
        frame.setTitle("Airsoft event tool");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        airsoftRegistrationTool.loadDatabase();
        refreshEvents();

    }


}

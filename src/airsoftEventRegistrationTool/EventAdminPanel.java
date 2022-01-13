package airsoftEventRegistrationTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class EventAdminPanel {
    private JLabel eventNameLabel;
    private JLabel eventParticipantsLabel;
    private JList playerList;
    private JPanel eventAdminPanel;
    private JTextField participantNameTextField;
    private JTextField participantSurnameTextField;
    private JButton registerNewParticipantButton;
    private JTextField participantEmailTextField;
    private JLabel incomePriceLabel;
    private JLabel totalIncomeLabel;
    private JLabel inputValidatorLabel;
    private JButton admineEventButtonDeleteAllPlayers;
    private JButton eventAdminPanelValidateInput;
    private Event event;

    private DefaultListModel <String> playerListPreview = new DefaultListModel<>();

    public void refreshData(){
        //Refreshes all data shown as well as the list of players
        eventParticipantsLabel.setText(Integer.toString(event.getPlayerlist().getPlayerList().size()));
        incomePriceLabel.setText(Double.toString(event.getEventPrice()));
        eventParticipantsLabel.setText(Integer.toString(event.getPlayerlist().getPlayerList().size()));
        totalIncomeLabel.setText(Double.toString(event.getPlayerlist().getPlayerList().size()*event.getEventPrice()));
        playerListPreview.removeAllElements();
        for(Player p: event.getPlayerlist().getPlayerList()){
            playerListPreview.addElement(p.getName() + " " + p.getSurname() + " ");
        }
    }

    public EventAdminPanel(Event event) {

        this.event = event;
        playerList.setModel(playerListPreview);



        registerNewParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean inputCorrect =false;
                String id = Integer.toString((event.getPlayerlist().getPlayerList().size() +1));
                String name= participantNameTextField.getText();
                String surname = participantSurnameTextField.getText();
                String mailadress =  participantEmailTextField.getText();
                if(name.equals("") || surname.equals("") || !EmailVerificator.isValid(mailadress) ||mailadress==null || event.getPlayerlist().checkDuplicate(name,surname)){
                    inputValidatorLabel.setText("Alle velden moeten ingevuld zijn");
                    inputValidatorLabel.setForeground(Color.RED);
                    if(!EmailVerificator.isValid(mailadress) ||mailadress==null ) {
                        participantEmailTextField.setText("Email is not allowed");
                    }
                    if (event.getPlayerlist().checkDuplicate(name,surname)){
                        inputValidatorLabel.setText("deze naam zit al in de lijst");

                    }
                }
                else{
                    inputCorrect=true;
                }
                if(inputCorrect){
                    Player participant = new Player(id,name,surname,mailadress);
                    String path = "files/eventID_" + event.getEventID() +".csv";
                    event.getPlayerlist().addPlayer(participant,path);
                    refreshData();
                }
            }
        });
        admineEventButtonDeleteAllPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.getPlayerlist().removeAllPlayers();
                try {
                    FileWriter myWriter = new FileWriter("files/eventID_"+event.getEventID()+".csv");
                    CSVReaderWriter.writeToUsers("",myWriter);
                    refreshData();
                    myWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });


            // Future remove player function

//        eventAdminButtonDeletePlayer.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selected = playerList.getSelectedValue().toString();
//                String selection[] = selected.split(" ");
//                System.out.println(selection[0]);
//                String path = "files/eventID_" + event.getEventID()+".csv";
//                event.getPlayerlist().removePlayer(selection[0],selection[1],path);
//                refreshData();
//
//            }
//        });
    }

    public void run() {
        JFrame frame = new JFrame();
//        testing if correct event is found
//        System.out.println(event);
        frame.setContentPane(eventAdminPanel);
        frame.setTitle("Event administration");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        eventNameLabel.setText(this.event.getName());

        refreshData();


    }
}

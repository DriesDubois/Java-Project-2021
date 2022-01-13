package airsoftEventRegistrationTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AirsoftRegistrationTool {
    private EventList eventList;
    private PlayerList playerList;

    public AirsoftRegistrationTool(EventList eventList, PlayerList playerList) {
        this.eventList = eventList;
        this.playerList = playerList;
    }

    public AirsoftRegistrationTool() {
        this.eventList = new EventList();

    }

    public void printAllEvents(){
        String s = "All events in the memory \n" + "--------------------------------------------------------------- \n";
        Path path  = Paths.get("files/Overview.txt");
        for (Event e :eventList.getEventMap().values()){
            s+="--------------------------------------------------------------- \n" +"Event ID: " + e.getEventID() + "\n" + "Naam event: " + e.getName() +"\n" + "aantal deelnemers: " + e.getPlayerlist().getPlayerList().size() + "\n" + "Players in the event: \n" + "--------------------------------------------------------------- \n";
            for (Player p : e.getPlayerlist().getPlayerList()){
                s+="- " +p.getSurname() +" " + p.getName() + " "+ p.getMailadress() + "\n";
            }
        }
        try {
            Files.writeString(path, s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    };

    public void loadDatabase(){

        for (Event event : eventList.getEventMap().values()){
            event.setPlayerlist(new PlayerList());
            if (event.getPlayerlist().getPlayerList()==null){
                try{
                    System.out.println("eerste tak");
                    String path="files/eventID_" + event.getEventID()+".csv";
                    File file = new File(path);
                    if (file.exists()){
                        event.getPlayerlist().setPlayerList(CSVReaderWriter.readPlayers(file));
                        System.out.println(event.getPlayerlist().getPlayerList());
                    }
                    else{
                        FileWriter myWriter = new FileWriter("files/eventID_" + event.getEventID()+".csv");
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }


}

package AirsoftEventRegistrationTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    private String eventID;
    private String name;
    private String host;
    private String location;
    private double organisationCosts;
    private double organisationIncome;
    private LocalDate date;
    private ArrayList<Player> playerlist;

    public Event( String eventID,String naam, String host, String location, LocalDate date) {
        this.name = naam;
        this.host = host;
        this.location = location;
        this.date = date;
        this.eventID = eventID;
        this.playerlist = new ArrayList<>();
    }

    public void UpdateOrAddUser(Player u) {
        try {
            String path = "files/eventid_" + this.eventID;
            File file = new File(path);
            FileWriter myWriter = new FileWriter(file);
            playerlist.add(u);
            for (Player player : playerlist) {
                CSVReaderWriter.writeToUsers(player.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCSVFormat() {
        return this.eventID + ";" + this.name + ";" + this.host + ";" + this.location + ";" + this.date + "\n";
    }

    public void addPlayer(Player u) {
        if (u != null) {
            playerlist.add(u);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfParticipants() {
        return playerlist.size();
    }

    public int calculateTotalParticipants(){
        return playerlist.size();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public ArrayList<Player> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(ArrayList<Player> playerlist) {
        this.playerlist = playerlist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getOrganisationCosts() {
        return organisationCosts;
    }

    public void setOrganisationCosts(double organisationCosts) {
        this.organisationCosts = organisationCosts;
    }

    public double getOrganisationIncome() {
        return organisationIncome;
    }

    public void setOrganisationIncome(double organisationIncome) {
        this.organisationIncome = organisationIncome;
    }

    @Override
    public String toString() {
        return "Event{" +
                "naam='" + name + '\'' +
                ", organisator='" + host + '\'' +
                ", locatie='" + location + '\'' +
                ", organisatiekosten=" + organisationCosts +
                ", organisatieinkomsten=" + organisationIncome +
                '}';
    }
}

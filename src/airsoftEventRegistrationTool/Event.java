package airsoftEventRegistrationTool;

import java.time.LocalDate;

public class Event {
    private String eventID;
    private String name;
    private String host;
    private String location;
    private LocalDate date;
    private double eventPrice;
    private PlayerList playerlist;


    public Event(String eventID, String naam, String host, String location, LocalDate date,double eventPrice) {
        this.name = naam;
        this.host = host;
        this.location = location;
        this.date = date;
        this.eventID = eventID;
        this.eventPrice = eventPrice;


    }



    public String getCSVFormat() {
        return this.eventID + ";" + this.name + ";" + this.host + ";" + this.location + ";" + this.date +";"+ this.eventPrice + "\n";
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PlayerList getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(PlayerList playerlist) {
        this.playerlist = playerlist;
    }

    public double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(double eventPrice) {
        this.eventPrice = eventPrice;
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


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Event{" +
                "naam='" + name + '\'' +
                ", organisator='" + host + '\'' +
                ", locatie='" + location + '\'' +
                '}';
    }
}

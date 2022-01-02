package AirsoftEventRegistrationTool;

import java.time.LocalDate;

public class Event {
    private String name;
    private String host;
//    private UserList userlist;
    private String location;
    private double organisationCosts;
    private double organisationIncome;
    private int numberOfParticipants;
    private LocalDate date;

    public Event(String naam, String host, String location , LocalDate date) {
        this.name = naam;
        this.host = host;
        this.location = location;
        this.date =date;

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
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

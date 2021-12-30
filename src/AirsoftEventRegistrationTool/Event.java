package AirsoftEventRegistrationTool;

public class Event {
    private String naam;
    private String organisator;
    private PlayerList playerlist;
    private String locatie;
    private double organisatiekosten;
    private double organisatieinkomsten;
    private int aantalDeelnemers;

    public Event(String naam, String organisator, PlayerList playerlist, String locatie, double organisatiekosten, double organisatieinkomsten , int aantalDeelnemers) {
        this.naam = naam;
        this.organisator = organisator;
        this.locatie = locatie;
        this.organisatiekosten = organisatiekosten;
        this.organisatieinkomsten = organisatieinkomsten;
        this.aantalDeelnemers=aantalDeelnemers;
    }

    public void addPlayerToEvent(Player p){
        this.playerlist.AddPlayer(p);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public PlayerList getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(PlayerList playerlist) {
        this.playerlist = playerlist;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public double getOrganisatiekosten() {
        return organisatiekosten;
    }

    public void setOrganisatiekosten(double organisatiekosten) {
        this.organisatiekosten = organisatiekosten;
    }

    public double getOrganisatieinkomsten() {
        return organisatieinkomsten;
    }

    public void setOrganisatieinkomsten(double organisatieinkomsten) {
        this.organisatieinkomsten = organisatieinkomsten;
    }

    @Override
    public String toString() {
        return "Event{" +
                "naam='" + naam + '\'' +
                ", organisator='" + organisator + '\'' +
                ", playerlist=" + playerlist +
                ", locatie='" + locatie + '\'' +
                ", organisatiekosten=" + organisatiekosten +
                ", organisatieinkomsten=" + organisatieinkomsten +
                '}';
    }
}

package airsoftEventRegistrationTool;

public class Player {
    private String name;
    private String surname;
    private String mailadress;
    private double registrationPrice;

    private String id;


    public Player(String id, String name, String surname, String mailadress ) {
        this.name = name;
        this.surname = surname;
        this.mailadress = mailadress;
        this.id = id;
    }

    public String getCSVFormat() {
        return this.id + ";" + this.name + ";" + this.surname + ";" + this.mailadress + ";" + this.registrationPrice + "\n";
    }


    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public double getPrice() {
        return registrationPrice;
    }

    public void setPrice(double registrationPrice) {
        this.registrationPrice = registrationPrice;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

    @Override
    public String toString() {
        return "UserID: " + this.id + " naam: " + this.surname + " " + this.name  + " mail: " + this.mailadress +  "\n";
    }
}

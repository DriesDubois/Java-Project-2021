package AirsoftEventRegistrationTool;

public class User {
    private String name;
    private String surname;
    private String mailadress;
    private double registrationPrice;
    private RentalKit rentalKit;
    private int id;

    public User(int id, String name, String surname, String mailadress) {
        this.name = name;
        this.surname = surname;
        this.mailadress = mailadress;
        this.id = id;
    }

    public String getCSVFormat() {
        return this.id + ";" + this.name + ";" + this.surname + ";" + this.mailadress + "\n";
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public double getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(double registrationPrice) {
        this.registrationPrice = registrationPrice;
    }

    public RentalKit getRentalKit() {
        return rentalKit;
    }

    public void setRentalKit(RentalKit rentalKit) {
        this.rentalKit = rentalKit;
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

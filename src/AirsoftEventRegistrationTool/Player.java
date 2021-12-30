package AirsoftEventRegistrationTool;

public class Player {
    private String name;
    private String surname;
    private String mailadress;
    private double registrationPrice;
    private RentalKit rentalKit;

    public Player(String name, String surname, String mailadress, double registrationPrice, RentalKit rentalKit) {
        this.name = name;
        this.surname = surname;
        this.mailadress = mailadress;
        this.registrationPrice = registrationPrice;
        this.rentalKit = rentalKit;
    }


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
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mailadress='" + mailadress + '\'' +
                '}';
    }
}

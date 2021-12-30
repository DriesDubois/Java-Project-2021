package AirsoftEventRegistrationTool;

public class Player {
    private String name;
    private String surname;
    private String mailadress;

    public Player(String name, String surname, String mailadress) {
        this.name = name;
        this.surname = surname;
        this.mailadress = mailadress;
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

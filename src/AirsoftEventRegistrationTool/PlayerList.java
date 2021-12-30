package AirsoftEventRegistrationTool;

import java.util.ArrayList;

public class PlayerList {

    private ArrayList<Player> playerlist = new ArrayList<>();

    public void AddPlayer (Player p){
        this.playerlist.add(p);
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerlist=" + playerlist +
                '}';
    }
}

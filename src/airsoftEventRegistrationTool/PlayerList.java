package airsoftEventRegistrationTool;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class PlayerList {
    private ArrayList<Player> playerList;


    public PlayerList() {

    }

    public void addPlayer(Player p, String path){

        try {
            FileWriter myWriter = new FileWriter(path);
            playerList.add(p);
            for (Player player : playerList) {
                CSVReaderWriter.writeToUsers(player.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public void removePlayer(String name, String surname, String path){

        Iterator<Player> it = playerList.iterator();

        while(it.hasNext()){
            if (it.next().getSurname().equals(surname)&&it.next().getName().equals(name)){
                playerList.remove(it);
            }
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            for (Player player : playerList) {
                CSVReaderWriter.writeToUsers(player.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }

    }



    public boolean checkDuplicate(String name , String surname ){

        for (Player player : playerList){
            if (player.getName().equals(name) && player.getSurname().equals(surname)){
                return true;
            }
        }
        return false;
    }

    public void removeAllPlayers(){
        playerList.clear();
    }




    public ArrayList<Player> getPlayerList() {
        return playerList;
    }



    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int calculateTotalParticipants(Event e){
        return playerList.size();
    }





}

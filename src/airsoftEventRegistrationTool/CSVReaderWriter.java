package airsoftEventRegistrationTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReaderWriter {

    public static Player createPlayer(String[] input) {
        String id = input[0];
        String name = input[1];
        String surname = input[2];
        String mailadress = input[3];

        return new Player(id, name, surname, mailadress);
    }



    public static Event createEvent(String[] input) {
        String eventID = input[0];
        String name = input[1];
        String host = input[2];
        String location = input[3];
        LocalDate date = LocalDate.parse(input[4]);
        double eventprice =Double.parseDouble(input[5]);
        String path = "eventID_" +eventID;
        return new Event(eventID, name, host, location, date , eventprice );
    }

    public static ArrayList<Player> readPlayers(File file) {
        ArrayList<Player> participantList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");
                Player participant = createPlayer(attributes);
                participantList.add(participant);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<Player>();
        }
        return participantList;
    }

    public static ArrayList<Event> readEvents(File file) {
        ArrayList<Event> eventList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");
                Event event = createEvent(attributes);
                eventList.add(event);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return eventList;

    }

    public static void writeToUsers(String stringObject, FileWriter myWriter) {

        try {
            myWriter.append(stringObject);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void writeToEvents(String stringObject, FileWriter myWriter) {

        try {
            myWriter.append(stringObject);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}





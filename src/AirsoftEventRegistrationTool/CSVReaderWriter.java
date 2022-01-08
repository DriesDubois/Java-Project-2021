package AirsoftEventRegistrationTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVReaderWriter {

    public static Player createUser(String[] input) {
        int id = Integer.parseInt(input[0]);
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

        return new Event(eventID, name, host, location, date);
    }

    public static ArrayList<Player> readUsers(File file) {
        ArrayList<Player> participantList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");
                Player participant = createUser(attributes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return participantList;
    }

    public static EventList readEvents(File file) {
        HashMap<String,Event> eventMap = new HashMap<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");
                Event event = createEvent(attributes);
                eventMap.put(event.getEventID(),event);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        EventList eventList = new EventList(eventMap);
        return eventList;
    }

    public static void writeToUsers(String stringObject, FileWriter myWriter){

        try{
            myWriter.append(stringObject);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void writeToEvents(String stringObject, FileWriter myWriter){

        try{
            myWriter.append(stringObject);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}





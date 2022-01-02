package AirsoftEventRegistrationTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReaderWriter {

    public static User createUser(String[] input) {
        int id = Integer.parseInt(input[0]);
        String name = input[1];
        String surname = input[2];
        String mailadress = input[3];

        return new User(id, name, surname, mailadress);


    }

    public static ArrayList<User> readUsers(File file) {
        ArrayList<User> participantList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");
                User participant = createUser(attributes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return participantList;
    }

    public static void writeToUsers(String stringObject, FileWriter myWriter){

        try{
            myWriter.append(stringObject);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}





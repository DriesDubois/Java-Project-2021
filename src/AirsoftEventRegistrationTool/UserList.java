package AirsoftEventRegistrationTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserList {

    private HashMap<Integer, User> usermap = new HashMap<>();

    public void UpdateOrAddUser(User u) {
        try {

            File file = new File("files/usermap.csv");
            FileWriter myWriter = new FileWriter("files/usermap.csv");
            usermap.put(u.getId(), u);
            for (User user : usermap.values()) {
                CSVReaderWriter.writeToUsers(user.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Userlist{" +
                "Userlist=" +"\n"+ usermap +
                '}' ;
    }
}

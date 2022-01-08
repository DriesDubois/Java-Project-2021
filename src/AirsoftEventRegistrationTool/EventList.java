package AirsoftEventRegistrationTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EventList {
    private HashMap<String,Event> eventList;

    public EventList(HashMap<String,Event> eventList) {
        this.eventList = eventList;
    }

    public EventList() {
        this.eventList = new HashMap<String,Event>();
    }

    public void UpdateOrAddEvent(Event e) {
        try {

            FileWriter myWriter = new FileWriter("files/events.csv");
            eventList.put(e.getEventID(), e);
            for (Event event : eventList.values()) {
                CSVReaderWriter.writeToEvents(event.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public Event selectEvent (String eventID){
        return eventList.get(eventID);
    }

    public HashMap<String, Event> getEventList() {
        return eventList;
    }

    public void setEventList(HashMap<String, Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        String s = "Eventlist : " + "\n";
        for(Event e : eventList.values()){
            s+=e.getEventID() +" " + e.getName() + " " + e.getHost() + " " + e.getLocation() + " " + e.getDate() + "\n";
        }
        return s;
    }
}

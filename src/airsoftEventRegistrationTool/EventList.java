package airsoftEventRegistrationTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EventList {
    private HashMap<String, Event> eventMap = new HashMap<>();

    public EventList() {
        ArrayList<Event> events = CSVReaderWriter.readEvents(new File("files/events.csv"));
        for (Event e : events) {
            eventMap.put(e.getEventID(), e);
        }
    }

    public void AddEvent(Event e) {
        try {
            FileWriter myWriter = new FileWriter("files/events.csv");
            eventMap.put(e.getEventID(), e);
            for (Event event : eventMap.values()) {
                CSVReaderWriter.writeToEvents(event.getCSVFormat(), myWriter);
            }
            myWriter.close();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public Event selectEvent(String eventID) {
        return eventMap.get(eventID);
    }

    public HashMap<String, Event> getEventMap() {
        return eventMap;
    }

    public void setEventMap(HashMap<String, Event> eventMap) {
        this.eventMap = eventMap;
    }

    public void setEventList(HashMap<String, Event> eventList) {
        this.eventMap = eventList;
    }

    @Override
    public String toString() {
        String s = "Eventlist : " + "\n";
        for (Event e : eventMap.values()) {
            s += e.getEventID() + " " + e.getName() + " " + e.getHost() + " " + e.getLocation() + " " + e.getDate() + "\n";
        }
        return s;
    }
}

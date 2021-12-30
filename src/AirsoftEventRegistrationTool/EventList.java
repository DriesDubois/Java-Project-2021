package AirsoftEventRegistrationTool;

import java.util.ArrayList;

public class EventList {
    private ArrayList<Event> eventList = new ArrayList<>();

    public void AddEventToList (Event e){
        this.eventList.add(e);
    }
}

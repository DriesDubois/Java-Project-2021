package AirsoftEventRegistrationTool;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        RegistrationPanel registrationPanel = new RegistrationPanel();
        // testing of object creation as well as csv writing/saving
        Player u1 = new Player(1,"Dubois","Dries","blah.com");
        Player u2 = new Player(2,"Dubois","Toon","blahdieblahfdhdfhdh.com");
        Player u3 = new Player(3,"Dubois","Erik","blahblah.com");
        Event e1 = new Event("1","test1","Toon","Fort Knox", LocalDate.now() );
        Event e2 = new Event("2","test2","Dries","Fort braem", LocalDate.now() );
        EventList el1 = new EventList();
        el1.UpdateOrAddEvent(e1);
        el1.UpdateOrAddEvent(e2);


        e1.UpdateOrAddUser(u1);
        e1.UpdateOrAddUser(u2);
        e1.UpdateOrAddUser(u3);
//        registrationPanel.run();
//        System.out.println(ul1);
//        System.out.println();
    }
}

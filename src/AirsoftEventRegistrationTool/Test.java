package AirsoftEventRegistrationTool;

public class Test {
    public static void main(String[] args) {
        RegistrationPanel registrationPanel = new RegistrationPanel();
        registrationPanel.run();
        User u1 = new User(1,"Dubois","Dries","blah.com");
        User u2 = new User(2,"Dubois","Toon","blahdieblah.com");
        User u3 = new User(3,"Dubois","Erik","blahblah.com");
        UserList ul1 = new UserList();
        ul1.UpdateOrAddUser(u1);
        ul1.UpdateOrAddUser(u2);
        ul1.UpdateOrAddUser(u3);
        System.out.println(ul1);
    }
}

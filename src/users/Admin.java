package users;

import storage.DataStorage;

import java.util.List;

public class Admin extends Employee {

    public Admin(String id, String firstName, String lastName, String email,
                 String password, double salary, String department) {
        super(id, firstName, lastName, email, password, salary, department);
    }

    public void addUser(User u) {
        DataStorage.getInstance().getUsers().add(u);
        DataStorage.getInstance().addLog("Admin added user: " + u.getFullName());
        System.out.println("User added: " + u.getFullName());
    }

    public void removeUser(User u) {
        DataStorage.getInstance().getUsers().remove(u);
        DataStorage.getInstance().addLog("Admin removed user: " + u.getFullName());
        System.out.println("User removed: " + u.getFullName());
    }

    public void updateUser(User u) {
        DataStorage.getInstance().addLog("Admin updated user: " + u.getFullName());
        System.out.println("User updated: " + u.getFullName());
    }

    public List<String> viewLogs() {
        return DataStorage.getInstance().getLogs();
    }
}
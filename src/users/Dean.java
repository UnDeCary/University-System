package users;

import complaints.IComplaint;
import communications.Request;
import enums.RequestStatus;
import storage.DataStorage;

import java.util.List;

public class Dean extends Employee {

    public Dean(String id, String firstName, String lastName, String email,
                String password, double salary, String department) {
        super(id, firstName, lastName, email, password, salary, department);
    }

    public void viewComplaints() {
        System.out.println("===== Complaints for the Dean =====");
        List<IComplaint> complaints = DataStorage.getInstance().getComplaints();
        if (complaints.isEmpty()) {
            System.out.println("No complaints.");
            return;
        }
        for (IComplaint c : complaints) {
            System.out.println(c.getText());
        }
    }

    public void signRequest(Request r) {
        r.setStatus(RequestStatus.ACCEPTED);
        System.out.println("Request signed by Dean " + getFullName());
    }
}
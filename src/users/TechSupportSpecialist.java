package users;

import communications.Request;
import enums.RequestStatus;
import storage.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class TechSupportSpecialist extends Employee {
    private List<Request> handledRequests;

    public TechSupportSpecialist(String id, String firstName, String lastName,
                                 String email, String password,
                                 double salary, String department) {
        super(id, firstName, lastName, email, password, salary, department);
        this.handledRequests = new ArrayList<>();
    }

    public void viewNewRequests() {
        System.out.println("===== New Requests =====");
        for (Request r : DataStorage.getInstance().getRequests()) {
            if (r.getStatus() == RequestStatus.NEW) {
                System.out.println(r);
                r.setStatus(RequestStatus.VIEWED); // автоматически переводим в VIEWED
            }
        }
    }

    public void acceptRequest(Request r) {
        r.setStatus(RequestStatus.ACCEPTED);
        handledRequests.add(r);
        System.out.println("Request accepted.");
    }

    public void rejectRequest(Request r) {
        r.setStatus(RequestStatus.REJECTED);
        System.out.println("Request rejected.");
    }

    public void markDone(Request r) {
        r.setStatus(RequestStatus.DONE);
        System.out.println("Request marked as done.");
    }
}
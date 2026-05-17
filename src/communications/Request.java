package communications;

import enums.RequestStatus;
import research.ResearchPaper;
import research.ResearchProject;
import users.Employee;
import users.Manager;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
    private Employee sender;
    private String text;
    private RequestStatus status;
    private Manager signedBy;
    private Date createdDate;

    public Request(Employee sender, String text, RequestStatus status){
        this.sender = sender;
        this.text = text;
        this.status = status;
        this.createdDate = new Date();
    }
    public void sign(Manager m){
        this.signedBy = m;
    }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus s) { this.status = s; }
    public Employee getSender() { return sender; }
    public String getText() { return text; }
    public Manager getSignedBy() { return signedBy; }

    @Override
    public String toString() {
        return "Request from " + sender.getFullName()
                + " | Status: " + status
                + " | Text: " + text;
    }


}

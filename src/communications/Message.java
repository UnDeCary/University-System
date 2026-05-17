package communications;

import users.User;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    public User from;
    public User to;
    public String content;
    public Date date;
    public Message(User from, User to, String content){
        this.from = from;
        this.content = content;
        this.to = to;
        this.date = new Date();
    }
    public void send() {
        System.out.println("[Message] " + (from != null ? from.getFullName() : "System")
                + " -> " + to.getFullName() + ": " + content);
    }

    @Override
    public String toString() {
        return "From " + (from != null ? from.getFullName() : "System")
                + " to " + to.getFullName() + ": " + content;
    }

}

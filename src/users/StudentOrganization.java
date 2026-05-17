package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentOrganization implements Serializable {
    private String organizationName;
    private String description;
    private Student head;
    private List<Student> members;

    public StudentOrganization(String organizationName, String description) {
        this.organizationName = organizationName;
        this.description = description;
        this.members = new ArrayList<>();
    }

    public void addMember(Student s) {
        if (!members.contains(s)) {
            members.add(s);
        }
    }

    public void removeMember(Student s) {
        members.remove(s);
        if (head != null && head.equals(s)) {
            head = null;
        }
    }

    public void setHead(Student s) {
        if (!members.contains(s)) addMember(s);
        this.head = s;
    }

    public boolean isHead(Student s) {
        return head != null && head.equals(s);
    }

    public String getName() { return organizationName; }
    public Student getHead() { return head; }
    public List<Student> getMembers() { return members; }
}
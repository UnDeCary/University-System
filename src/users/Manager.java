package users;

import comparators.StudentGpaComparator;
import communications.News;
import communications.Request;
import enums.ManagerType;
import enums.RequestStatus;
import storage.DataStorage;
import university.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manager extends Employee {
    private ManagerType managerType;
    private List<Request> incomingRequests;

    public Manager(String id, String firstName, String lastName, String email,
                   String password, double salary, String department,
                   ManagerType managerType) {
        super(id, firstName, lastName, email, password, salary, department);
        this.managerType = managerType;
        this.incomingRequests = new ArrayList<>();
    }

    public void assignCourse(Teacher t, Course c) {
        t.manageCourse(c);
        System.out.println("Course " + c.getName() + " assigned to " + t.getFullName());
    }

    public void approveRegistration(Student s, Course c) {
        System.out.println("Manager approved registration of "
                + s.getFullName() + " for " + c.getName());
    }

    public void addCourseForRegistration(Course c) {
        DataStorage.getInstance().getCourses().add(c);
        System.out.println("Course added for registration: " + c.getName());
    }

    public String createReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Performance Report =====\n");
        List<Student> students = new ArrayList<>();
        for (User u : DataStorage.getInstance().getUsers()) {
            if (u instanceof Student) students.add((Student) u);
        }
        students.sort(new StudentGpaComparator());
        for (Student s : students) {
            sb.append(s.getFullName())
                    .append(" — GPA: ").append(s.getGpa())
                    .append(" — Credits: ").append(s.getCredits())
                    .append("\n");
        }
        return sb.toString();
    }

    public void manageNews(News n) {
        DataStorage.getInstance().getNews().add(n);
        System.out.println("News added: " + n.getTitle());
    }

    public List<Student> viewStudents(Comparator<Student> comparator) {
        List<Student> students = new ArrayList<>();
        for (User u : DataStorage.getInstance().getUsers()) {
            if (u instanceof Student) students.add((Student) u);
        }
        students.sort(comparator);
        return students;
    }

    public void viewRequests() {
        System.out.println("===== Incoming Requests =====");
        for (Request r : incomingRequests) {
            System.out.println(r);
        }
    }

    public void receiveRequest(Request r) {
        incomingRequests.add(r);
    }

    public void signRequest(Request r) {
        r.sign(this);
        r.setStatus(RequestStatus.ACCEPTED);
        System.out.println("Request signed by " + getFullName());
    }

    public void rejectRequest(Request r) {
        r.setStatus(RequestStatus.REJECTED);
        System.out.println("Request rejected by " + getFullName());
    }

    public ManagerType getManagerType() { return managerType; }
}
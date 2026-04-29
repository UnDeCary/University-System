package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import users.User;

import services.Admin;
import services.Manager;
import services.Teacher;
import services.TechSupportSpecialist;

import university.Course;
import university.Mark;


public class Student extends User {

    private String studentId;
    private double gpa;
    private int credits;
    private List<Course> courses;
    private Map<Course, Mark> marks;
    private int failCount;
    private StudentOrganization organization;

    public Student(String id, String firstName, String lastName, String email, String password, Language language, String studentId) {
        super(id, firstName, lastName, email, password, language);
        this.studentId = studentId;
        this.gpa = 0.0;
        this.credits = 0;
        this.failCount = 0;
        this.courses = new ArrayList<>();
        this.marks = new HashMap<>();
        this.organization = null;
    }

    @Override
    public boolean login() {
        System.out.println("Student " + getFirstName() + " logged in.");
        return true;
    }

    @Override
    public void logout() {
        System.out.println("Student " + getFirstName() + " logged out.");
    }

    @Override
    public void sendMessage(User to, String text) {
        System.out.println("Message from " + getFirstName() + " to " + to.getFirstName() + ": " + text);
    }

    public void registerCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
        }
    }

    public List<Course> viewCourses() {
        return this.courses;
    }

    public Map<Course, Mark> viewMarks() {
        return this.marks;
    }

    public String getTranscript() {
        return "Transcript for " + getFirstName() + " " + getLastName() + "\nGPA: " + gpa;
    }

    public void rateTeacher(Teacher t, double rating) {
        System.out.println("Rated teacher " + t.getName() + " with " + rating);
    }

    public String viewTeacherInfo(Teacher t) {
        return "Info about teacher: " + t.getName();
    }

    public void joinOrganization(StudentOrganization org) {
        this.organization = org;
        System.out.println(getFirstName() + " joined " + org.getName());
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public int getFailCount() { return failCount; }
    public void setFailCount(int failCount) { this.failCount = failCount; }
    public StudentOrganization getOrganization() { return organization; }
}
package services;

import university.Course;
import university.Mark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private String studentId;
    private double gpa;
    private int credits;
    private List<Course> courses;
    private Map<Course, Mark> marks;
    private int failCount;
    private StudentOrganization organization;

    public Student(String id, String firstName, String lastName, String email, String password, String studentId) {
        super(id, firstName, lastName, email, password);
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        this.marks = new HashMap<>();
        this.credits = 0;
        this.failCount = 0;
    }

    public void registerCourse(Course c) throws CreditLimitException {
        if (this.credits + c.getCredits() > 21) {
            throw new CreditLimitException("Credit limit exceeded");
        }
        if (this.failCount >= 3) {
            throw new RuntimeException("Fail count limit reached");
        }
        this.courses.add(c);
        this.credits += c.getCredits();
        c.enrollStudent(this);
    }

    public String getTranscript() {
        return "Transcript for " + toString();
    }
}

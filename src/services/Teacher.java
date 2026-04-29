package services;

import enums.TeacherPosition;
import enums.Urgency;
import university.Course;
import university.Mark;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private TeacherPosition position;
    private List<Course> courses;
    private double rating;

    public Teacher(String id, String firstName, String lastName, String email, String password, double salary, String department, TeacherPosition position) {
        super(id, firstName, lastName, email, password, salary, department);
        this.position = position;
        this.courses = new ArrayList<>();
    }

    public void putMark(Student s, Course c, Mark m) {
    }

    public void sendComplaint(Student s, Urgency urgency, String text) {
    }
}

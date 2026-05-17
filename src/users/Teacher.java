package users;

import complaints.BaseComplaint;
import complaints.UrgencyDecorator;
import enums.TeacherPosition;
import enums.Urgency;
import research.RecommendationLetter;
import storage.DataStorage;
import university.Course;
import university.Mark;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private TeacherPosition position;
    private List<Course> courses;
    private List<Double> ratings;

    public Teacher(String id, String firstName, String lastName, String email,
                   String password, double salary, String department,
                   TeacherPosition position) {
        super(id, firstName, lastName, email, password, salary, department);
        this.position = position;
        this.courses = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public List<Course> viewCourses() {
        return courses;
    }

    public void putMark(Student s, Course c, Mark m) {
        if (!c.getEnrolledStudents().contains(s)) {
            System.out.println("Error: student is not enrolled in this course.");
            return;
        }
        s.addMark(c, m);
        System.out.println("Mark put for " + s.getFullName() + " in " + c.getName());
    }

    public List<Student> viewStudents(Course c) {
        return c.getEnrolledStudents();
    }

    public void sendComplaint(Student s, Urgency urgency, String text) {
        BaseComplaint base = new BaseComplaint(text, s, this);
        UrgencyDecorator complaint = new UrgencyDecorator(urgency, base);
        DataStorage.getInstance().addComplaint(complaint);
        System.out.println("Complaint sent: " + complaint.getText());
    }

    public void manageCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.addTeacher(this);
        }
    }

    public RecommendationLetter writeLetter(Student s, String text) {
        return new RecommendationLetter(text, this, s);
    }

    public void addRating(double rating) {
        ratings.add(rating);
    }

    public double getRating() {
        if (ratings.isEmpty()) return 0;
        double sum = 0;
        for (Double r : ratings) sum += r;
        return sum / ratings.size();
    }

    public TeacherPosition getPosition() { return position; }

    public boolean isMandatoryResearcher() {
        return position == TeacherPosition.PROFESSOR;
    }
}
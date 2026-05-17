package users;

import enums.DegreeType;
import exceptions.CreditLimitException;
import exceptions.MaxFailException;
import university.Course;
import university.Mark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {
    public static final int MAX_CREDITS = 21;
    public static final int MAX_FAILS = 3;

    private String studentId;
    private double gpa;
    private int credits;
    private List<Course> courses;
    private Map<Course, Mark> marks;
    private int failCount;
    private StudentOrganization organization;

    public Student(String id, String firstName, String lastName,
                   String email, String password, String studentId) {
        super(id, firstName, lastName, email, password);
        this.studentId = studentId;
        this.gpa = 0.0;
        this.credits = 0;
        this.failCount = 0;
        this.courses = new ArrayList<>();
        this.marks = new HashMap<>();
        this.organization = null;
    }

    public void registerCourse(Course c) throws CreditLimitException, MaxFailException {
        if (this.credits + c.getCredits() > MAX_CREDITS) {
            throw new CreditLimitException(
                    "Cannot register: credit limit (" + MAX_CREDITS + ") exceeded.");
        }
        if (this.failCount >= MAX_FAILS) {
            throw new MaxFailException(
                    "Cannot register: student has already failed " + failCount + " times.");
        }
        if (!courses.contains(c)) {
            courses.add(c);
            this.credits += c.getCredits();
            c.enrollStudent(this);
            System.out.println(getFullName() + " registered for course: " + c.getName());
        }
    }

    public List<Course> viewCourses() {
        return courses;
    }

    public Map<Course, Mark> viewMarks() {
        return marks;
    }

    public String getTranscript() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Transcript of ").append(getFullName()).append(" =====\n");
        sb.append("Student ID: ").append(studentId).append("\n");
        sb.append("GPA: ").append(gpa).append("\n");
        sb.append("Credits: ").append(credits).append("\n\n");
        for (Map.Entry<Course, Mark> e : marks.entrySet()) {
            sb.append(e.getKey().getName())
                    .append(" — ")
                    .append(e.getValue().getGrade())
                    .append(" (")
                    .append(e.getValue().getTotal())
                    .append(")\n");
        }
        return sb.toString();
    }

    public void rateTeacher(Teacher t, double rating) {
        t.addRating(rating);
        System.out.println(getFullName() + " rated " + t.getFullName() + " with " + rating);
    }

    public String viewTeacherInfo(Teacher t) {
        return "Teacher: " + t.getFullName()
                + ", position: " + t.getPosition()
                + ", rating: " + t.getRating();
    }

    public void joinOrganization(StudentOrganization org) {
        this.organization = org;
        org.addMember(this);
    }

    public void addMark(Course c, Mark m) {
        marks.put(c, m);
        recalculateGpa();
        if (m.isFailed()) {
            failCount++;
        }
    }

    private void recalculateGpa() {
        if (marks.isEmpty()) { gpa = 0; return; }
        double sum = 0;
        for (Mark m : marks.values()) sum += m.getTotal();
        gpa = sum / marks.size() / 25.0; // приводим к шкале 0-4
    }

    // Можно ли быть researcher автоматически (Master/PhD — да)
    public boolean isMandatoryResearcher() {
        if (this instanceof GraduateStudent) {
            DegreeType d = ((GraduateStudent) this).getDegree();
            return d == DegreeType.MASTER || d == DegreeType.PHD;
        }
        return false;
    }

    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }
    public int getCredits() { return credits; }
    public int getFailCount() { return failCount; }
    public StudentOrganization getOrganization() { return organization; }
}
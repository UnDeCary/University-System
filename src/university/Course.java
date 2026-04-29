package university;

import enums.CourseType;
import services.Teacher;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private int credits;
    private CourseType courseType;
    private List<Teacher> teachers;
    private List<Student> enrolledStudents;

    public Course(String courseId, String name, int credits, CourseType type) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.courseType = type;
        this.teachers = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCredits() {
        return credits;
    }

    public void enrollStudent(Student s) {
        this.enrolledStudents.add(s);
    }
}
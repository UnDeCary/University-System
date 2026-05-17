package university;

import enums.CourseType;
import enums.LessonType;
import users.Teacher;
import users.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable {
    private String courseId;
    private String name;
    private int credits;
    private CourseType courseType;
    private List<Teacher> teachers;
    private List<Student> enrolledStudents;
    private List<Lesson> lessons;

    public Course(String courseId, String name, int credits, CourseType type) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.courseType = type;
        this.teachers = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }
    public void addLesson(Lesson l){
        lessons.add(l);
    }
    public void addTeacher(Teacher t){
        if (!(teachers.contains(t))){
            teachers.add(t);
        }
    }


    public void enrollStudent(Student s) {
        if (!enrolledStudents.contains(s)) {
            enrolledStudents.add(s);
        }
    }
    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public CourseType getCourseType() { return courseType; }
    public List<Lesson> getLessons() { return lessons; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    @Override
    public String toString() {
        return name + " (" + courseId + ", " + credits + " credits, " + courseType + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course c = (Course) o;
        return Objects.equals(courseId, c.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}
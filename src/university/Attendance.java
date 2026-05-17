package university;

import users.Student;

public class Attendance {
    private Lesson lesson;
    private Student student;
    private boolean isPresent;

    public Attendance(Lesson lesson, Student student) {
        this.lesson = lesson;
        this.student = student;
        this.isPresent = false;
    }

    public void markAtt(boolean presence) {
        this.isPresent = presence;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public Lesson getLesson() { return lesson; }
    public Student getStudent() { return student; }

}

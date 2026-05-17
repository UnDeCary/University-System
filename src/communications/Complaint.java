package communications;

import enums.Urgency;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable{
    private String text;
    private Student targetedStudent;
    private Teacher teacher;
    private Urgency urgency;
    private Date date;
    private Complaint(String text, Student targetedStudent, Teacher teacher, Urgency urgency){
        this.text = text;
        this.targetedStudent = targetedStudent;
        this.teacher = teacher;
        this.urgency = urgency;
    }
    public String getText() {
        return "[Urgency: " + urgency + "] Complaint from "
                + teacher.getFullName()
                + " about student " + targetedStudent.getFullName()
                + ": " + text;
    }

    public Urgency getUrgency() { return urgency; }
    public Student getTargetedStudent() { return targetedStudent; }
    public Teacher getTeacher() { return teacher; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return getText();
    }
}


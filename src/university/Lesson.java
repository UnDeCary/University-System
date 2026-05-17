package university;

import enums.LessonType;
import users.Teacher;

import java.util.Date;

public class Lesson {
    private String lessonId;
    private LessonType type;
    private Teacher teacher;
    private Course course;
    private Date date;
    public Lesson(String lessonId, LessonType type, Teacher teacher, Course course, Date date){
        this.lessonId = lessonId;
        this.type = type;
        this.teacher = teacher;
        this.course = course;
        this.date = date;
    }

    public String getInfo(){
        return "Lesson " + lessonId + " | " + course.getName() + " | " + type + " | " + teacher.getFullName() + " | " + date;
    }
    public String getLessonId() { return lessonId; }
    public LessonType getType() { return type; }
    public Teacher getTeacher() { return teacher; }
    public Course getCourse() { return course; }
    public Date getDate() { return date; }

}

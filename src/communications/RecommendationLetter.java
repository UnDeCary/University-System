package communications;

import users.Student;
import users.Teacher;

import java.io.Serializable;

public class RecommendationLetter implements Serializable {
    private String text;
    private Teacher author;
    private Student student;
    public RecommendationLetter(String text, Teacher author, Student student){
        this.text = text;
        this.author = author;
        this.student = student;
    }
    public String getText(){
        return "Recommendation letter for " + student.getFullName() + " from " + author.getFullName() + ":\n" + text;
    }

}

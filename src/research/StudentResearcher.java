package research;

import users.Student;

public class StudentResearcher extends ResearcherDecorator {

    public StudentResearcher(Student s) {
        super(s);
    }

    public Student getStudent() {
        return (Student) decoratedUser;
    }
}
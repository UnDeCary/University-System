package research;

import users.Teacher;

public class TeacherResearcher extends ResearcherDecorator {

    public TeacherResearcher(Teacher t) {
        super(t);
    }

    public Teacher getTeacher() {
        return (Teacher) decoratedUser;
    }
}
package research;

import users.Employee;
import users.Student;
import users.Teacher;

public class EmployeeResearcher extends ResearcherDecorator {

    public EmployeeResearcher(Employee e) {
        super(e);
        if (e instanceof Teacher) {
            System.out.println("Warning: use TeacherResearcher for teachers.");
        }
        if (e instanceof Student) {
            System.out.println("Warning: use StudentResearcher for students.");
        }
    }

    public Employee getEmployee() {
        return (Employee) decoratedUser;
    }
}
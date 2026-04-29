import enums.Language;
import users.User;
import java.util.Objects;

public abstract class Employee extends User {
    private double salary;
    private String department;

    public Employee(String id, String firstName, String lastName, String email,
                    String password, Language language, double salary, String department) {
        super(id, firstName, lastName, email, password, language);
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInfo() {
        return String.format("Employee: %s %s, Dept: %s, Salary: %.2f",
                getFirstName(), getLastName(), department, salary);
    }

    public void sendRequest(Request req) {
        System.out.println("Request sent by " + getFirstName() + ": " + req.toString());
    }

    @Override
    public void sendMessage(User to, String text) {
        System.out.println("Message from " + getFirstName() + " to " + to.getFirstName() + ": " + text);
    }

    @Override
    public boolean login() {
        System.out.println("Employee " + getEmail() + " logged in.");
        return true;
    }

    @Override
    public void logout() {
        System.out.println("Employee " + getEmail() + " logged out.");
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" +
                "salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
package users;

import communications.Request;

public abstract class Employee extends User {
    private double salary;
    private String department;

    public Employee(String id, String firstName, String lastName, String email,
                    String password, double salary, String department) {
        super(id, firstName, lastName, email, password);
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public String getInfo() {
        return toString() + " | Department: " + department + " | Salary: " + salary;
    }

    public void sendRequest(Request req) {
        System.out.println(getFullName() + " sent a request: " + req.getText());
    }
}
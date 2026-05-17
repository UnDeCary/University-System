package university;

import users.Student;

public class Mark {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private Student student;
    private Course course;

    public Mark(double finalExam, double secondAttestation, double firstAttestation, Student student, Course course){
        this.student = student;
        this.course = course;
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }
    public double getTotal(){
        return firstAttestation + secondAttestation + finalExam;
    }
    public String getGrade(){
        double t = getTotal();
        if (t >= 90) return "A";
        if (t >= 75) return "B";
        if (t >= 60) return "C";
        if (t >= 50) return "D";
        return "F";
    }
    public boolean isFailed() {
        return getTotal() < 50;
    }

    @Override
    public String toString() {
        return getGrade() + " (" + getTotal() + ")";
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }


}

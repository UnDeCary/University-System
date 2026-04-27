package complaints;

public class BaseComplaint implements  IComplaint{
    private String text;
    private Student targetedStudent;
    private Teacher teacher;

    public BaseComplaint(String text, Student targetedStudent, Teacher teacher){
        this.text = text;
        this.targetedStudent = targetedStudent;
        this.teacher = teacher;
    }
    @Override
    public String getText(){
        return "Complaint from " + teacher + " to the student: " + targetedStudent + ":" + text;
    }

}

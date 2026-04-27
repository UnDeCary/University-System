package complaints;

import enums.Urgency;

public class UrgencyDecorator extends ComplaintDecorator{
    private Urgency urgency;
    public UrgencyDecorator(Urgency urgency, IComplaint c){
        super(c);
        this.urgency = urgency;
    }
    @Override
    public String getText(){
        return "Urgency - " + urgency + super.getText();
    }
}

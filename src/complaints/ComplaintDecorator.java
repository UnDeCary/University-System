package complaints;

public abstract class ComplaintDecorator implements  IComplaint{
    protected IComplaint wrapper;
    public ComplaintDecorator(IComplaint c){
        this.wrapper = c;
    }
    @Override
    public String getText(){
        return wrapper.getText();
    }
}

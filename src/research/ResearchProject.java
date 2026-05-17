package research;
import users.User;
import exceptions.NotResearcherException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResearchProject implements Serializable {
    private String topic;
    private List<ResearchPaper> papers;
    private List<IResearcher> participants;
    private ResearchProject(String topic){
        this.topic = topic;
        this.papers = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void addParticipant(User u) throws NotResearcherException{
        throw new NotResearcherException("Only IResearcher instances can join. Wrap user with a Researcher decorator first.");
    }
    public void addParticipant(IResearcher r){
        if (!(participants.contains(r))){
            participants.add(r);
        }
        if (r instanceof ResearcherDecorator) {
            ((ResearcherDecorator) r).addProject(this);
        }
    }
    public void addPaper(ResearchPaper paper){
        this.papers.add(paper);
    }
    public List<IResearcher> getParticipants() { return participants; }
    public List<ResearchPaper> getPapers() { return papers; }
    public String getTopic() { return topic; }
}


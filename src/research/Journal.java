package research;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal implements Serializable {

    private String name;
    private List<ResearchPaper> papers;
    private List<SubscriberObserver> subscribers;

    public Journal(String name) {
        this.name = name;
        this.papers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(SubscriberObserver s) {
        subscribers.add(s);
    }

    public void unsubscribe(SubscriberObserver s) {
        subscribers.remove(s);
    }

    public void publishPaper(ResearchPaper p) {
        papers.add(p);
        notifySubscribers();
    }

    private void notifySubscribers() {
        ResearchPaper lastPaper = papers.get(papers.size() - 1);
        for (SubscriberObserver s : subscribers) {
            s.update(name, lastPaper);
        }
    }

    public String getName() { return name; }
    public List<ResearchPaper> getPapers() { return papers; }
}
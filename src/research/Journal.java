package research;

import communications.News;
import storage.DataStorage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal implements Serializable {

    private String name;
    private List<ResearchPaper> papers;
    private List<Subscriber> subscribers;

    public Journal(String name) {
        this.name = name;
        this.papers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void publishPaper(ResearchPaper p) {
        papers.add(p);
        notifySubscribers();
        News n = new News(
                "New paper in " + name,
                "Paper '" + p.getTitle() + "' has been published.",
                "Research"
        );
        DataStorage.getInstance().getNews().add(n);
    }

    private void notifySubscribers() {
        ResearchPaper lastPaper = papers.get(papers.size() - 1);
        for (Subscriber s : subscribers) {
            s.update(name, lastPaper);
        }
    }

    public String getName() { return name; }
    public List<ResearchPaper> getPapers() { return papers; }
    public List<Subscriber> getSubscribers() { return subscribers; }
}
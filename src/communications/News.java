package communications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News implements Serializable {
    public static final String RESEARCH_TOPIC = "RESEARCH";
    private String title;
    private String content;
    private String topic;
    private List<String> comments;
    private boolean isPinned;
    private Date date;

    public News(String title, String content, String topic) {
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.comments = new ArrayList<>();
        this.date = new Date();
        // авто-pin для исследовательских новостей
        this.isPinned = RESEARCH_TOPIC.equalsIgnoreCase(topic);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void pin() {
        this.isPinned = true;
    }

    public boolean isPinned() { return isPinned; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getTopic() { return topic; }
    public List<String> getComments() { return comments; }
    @Override
    public String toString() {
        String pinStr = isPinned ? "[PINNED] " : "";
        return pinStr + title + " (" + topic + ") — " + content;
    }
}

package research;

import users.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearcherDecorator implements IResearcher {
    protected User decoratedUser;
    protected List<ResearchPaper> papers;
    protected List<ResearchProject> projects;

    public ResearcherDecorator(User user) {
        this.decoratedUser = user;
        this.papers = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    @Override
    public int calculateHIndex() {
        List<ResearchPaper> sorted = new ArrayList<>(papers);
        sorted.sort((a, b) -> Integer.compare(b.getCitations(), a.getCitations()));
        int h = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).getCitations() >= i + 1) {
                h = i + 1;
            } else {
                break;
            }

        }
        return h;


    }
    @Override
    public void printPapers(Comparator<ResearchPaper> c){
        List<ResearchPaper> sorted = new ArrayList<>(papers);
        sorted.sort(c);
        System.out.println("===== Papers of " + decoratedUser.getFullName() + " =====");
        for (ResearchPaper p : sorted) {
            System.out.println(p);
        }
    }
    @Override
    public void addPaper(ResearchPaper p) {
        papers.add(p);
    }


    public List<ResearchPaper> getPapers() { return papers; }

    @Override
    public List<ResearchProject> getProjects() { return projects; }

    public void addProject(ResearchProject project) {
        if (!projects.contains(project)) {
            projects.add(project);
        }
    }

    public User getDecoratedUser() { return decoratedUser; }



}

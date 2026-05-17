package research;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public interface IResearcher extends Serializable {
    int calculateHIndex();
    void printPapers(Comparator<ResearchPaper> c);
    void addPaper(ResearchPaper p);
    List<ResearchProject> getProjects();
}
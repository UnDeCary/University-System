package users;

import enums.DegreeType;
import exceptions.LowHIndexException;
import research.IResearcher;
import research.ResearchPaper;

import java.util.ArrayList;
import java.util.List;

public class GraduateStudent extends Student {
    private DegreeType degree;
    private IResearcher supervisor;
    private List<ResearchPaper> diplomaPapers;

    public GraduateStudent(String id, String firstName, String lastName,
                           String email, String password, String studentId,
                           DegreeType degree) {
        super(id, firstName, lastName, email, password, studentId);
        this.degree = degree;
        this.diplomaPapers = new ArrayList<>();
    }

    public void setSupervisor(IResearcher r) throws LowHIndexException {
        if (r.calculateHIndex() < 3) {
            throw new LowHIndexException(
                    "Supervisor must have h-index >= 3, got: " + r.calculateHIndex());
        }
        this.supervisor = r;
        System.out.println("Supervisor assigned to " + getFullName());
    }

    public void addDiplomaPaper(ResearchPaper p) {
        diplomaPapers.add(p);
    }

    public DegreeType getDegree() { return degree; }
    public IResearcher getSupervisor() { return supervisor; }
    public List<ResearchPaper> getDiplomaPapers() { return diplomaPapers; }
}
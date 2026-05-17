package research;

import enums.CitationFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResearchPaper implements Comparable<ResearchPaper>, Serializable {

    private String title;
    private List<String> authors;
    private String journal;
    private int pages;
    private Date date;
    private String doi;
    private int citations;

    public ResearchPaper(String title, List<String> authors, String journal,
                         int pages, Date date, String doi, int citations) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.date = date;
        this.doi = doi;
        this.citations = citations;
    }

    public String getCitation(CitationFormat format) {
        int year = date.getYear() + 1900;
        String authorsStr = String.join(", ", authors);

        if (format == CitationFormat.PLAIN_TEXT) {
            return authorsStr + ". (" + year + "). " + title + ". " + journal + ". " + doi;
        } else { // BIBTEX
            return "@article{" + doi + ",\n" +
                    "  author={" + authorsStr + "},\n" +
                    "  title={" + title + "},\n" +
                    "  journal={" + journal + "},\n" +
                    "  year={" + year + "},\n" +
                    "  doi={" + doi + "}\n" +
                    "}";
        }
    }

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" — " + String.join(", ", authors) + " (" + citations + " citations)";
    }
    public int getCitations() { return citations; }
    public Date getDate() { return date; }
    public String getTitle() { return title; }
    public void addCitation() { this.citations++; }
}
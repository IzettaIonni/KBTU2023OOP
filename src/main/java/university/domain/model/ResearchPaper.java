package university.domain.model;

import java.util.List;

public class ResearchPaper {


    private String name;
    private List<String> authors;
    private String citePlain;
    private String citeBibtex;
    private String journal;
    private Integer pages;

    public String getCitation(ResearchPaperFormat format) {
        if (format == ResearchPaperFormat.PLAIN_TEXT) return citePlain;
        if (format == ResearchPaperFormat.BIBTEX) return citeBibtex;
    }

}

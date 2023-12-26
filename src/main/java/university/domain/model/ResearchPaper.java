package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ResearchPaper implements Serializable {

    @NonNull
    private final ResearchPaperId id;
    @NonNull
    private String name;
    @NonNull
    private List<String> authors;
    @NonNull
    private String citePlain;
    @NonNull
    private String citeBibtex;
    @NonNull
    private String journal;
    @NonNull
    private Integer pages;
    @NonNull
    private School school;

    public String getCitation(ResearchPaperFormat format) {
        if (format == ResearchPaperFormat.PLAIN_TEXT) return citePlain;
        if (format == ResearchPaperFormat.BIBTEX) return citeBibtex;
        else throw new IllegalArgumentException();
    }

}

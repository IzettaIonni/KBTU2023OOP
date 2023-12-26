package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Data
@Builder(toBuilder = true)
public class UpdateResearchPaper {

    @NonNull
    ResearchPaperId id;
    private String name;
    private List<String> authors;
    private String citePlain;
    private String citeBibtex;
    private String journal;
    private Integer pages;

}

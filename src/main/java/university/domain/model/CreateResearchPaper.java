package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Data
@Builder(toBuilder = true)
public class CreateResearchPaper {
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

}

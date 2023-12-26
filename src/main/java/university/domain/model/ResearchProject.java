package university.domain.model;

import java.io.Serializable;
import java.util.List;

public class ResearchProject implements Serializable {

    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<UserId> participants;

}

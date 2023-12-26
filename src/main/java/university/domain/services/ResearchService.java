package university.domain.services;

import university.domain.model.*;

import java.util.Comparator;
import java.util.List;

public interface ResearchService {

    ResearchPaper getResearchPaper(ResearchPaperId id);
    ResearchPaper createResearchPaper(CreateResearchPaper request);
    ResearchPaper updateResearchPaper(UpdateResearchPaper request);
    void deleteResearchPaper(ResearchPaperId id);
    List<ResearchPaper> getAllResearchPapers(Comparator<ResearchPaper> comparator);
    String getTopResearcherOfSchool(School school);
    String getTopResearcherOfYear();

}

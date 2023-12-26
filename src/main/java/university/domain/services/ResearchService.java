package university.domain.services;

import university.domain.model.*;
import university.domain.model.decorator.MasterDecorator;
import university.domain.model.decorator.PhDDecorator;
import university.domain.model.decorator.ProfessorDecorator;
import university.domain.model.decorator.ResearcherDecorator;

import java.util.Comparator;
import java.util.List;

public interface ResearchService {

    MasterDecorator addMasterDegree(User user);
    PhDDecorator addPhD(User user);
    ProfessorDecorator addProfessorDegree(Teacher teacher);
    ResearcherDecorator addResearcherForEmployee(Employee employee);
    ResearchPaper getResearchPaper(ResearchPaperId id);
    ResearchPaper createResearchPaper(CreateResearchPaper request);
    ResearchPaper updateResearchPaper(UpdateResearchPaper request);
    void deleteResearchPaper(ResearchPaperId id);
    List<ResearchPaper> getAllResearchPapers(Comparator<ResearchPaper> comparator);
    Researcher getTopResearcherOfSchool(School school);
    Researcher getTopResearcherOfYear();

}

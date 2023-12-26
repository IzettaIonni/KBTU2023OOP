package university.domain.model;

import java.util.Comparator;

public interface Researcher {

    ResearchPaper printPapers(Comparator<ResearchPaper> comparator);
    Integer getHIndex();

}

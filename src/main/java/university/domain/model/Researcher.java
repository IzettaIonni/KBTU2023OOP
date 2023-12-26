package university.domain.model;

import java.util.Comparator;
import java.util.List;

public interface Researcher {

    List<ResearchPaper> printPapers(Comparator<ResearchPaper> comparator);
    Integer getHIndex();

}

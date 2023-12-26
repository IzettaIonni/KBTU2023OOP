package university.domain.model.comparators;

import university.domain.model.ResearchPaper;

import java.util.Comparator;

public class ResearchPaperComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper o1, ResearchPaper o2) {
        return o1.getPages() - o2.getPages();
    }
}

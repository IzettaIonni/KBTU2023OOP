package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.model.comparators.ResearchPaperComparator;
import university.domain.services.ResearchService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchServiceImpl implements ResearchService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public ResearchPaper getResearchPaper(ResearchPaperId id) {
        for (var researchPaper : dataStorage.researchPapers) {
            if (researchPaper.getId().equals(id)) return researchPaper;
        }
        return null;
    }

    @Override
    public ResearchPaper createResearchPaper(CreateResearchPaper request) {
        var researchPaper = new ResearchPaper(ResearchPaperId.randomId(), request.getName(), request.getAuthors(),
                request.getCitePlain(), request.getCiteBibtex(), request.getJournal(), request.getPages(), request.getSchool());
        dataStorage.researchPapers.add(researchPaper);
        return researchPaper;
    }

    @Override
    public ResearchPaper updateResearchPaper(UpdateResearchPaper request) {
        var researchPaper = getResearchPaper(request.getId());
        if (researchPaper == null) return null;
        researchPaper.setName(request.getName());
        researchPaper.setAuthors(request.getAuthors());
        researchPaper.setCitePlain(request.getCitePlain());
        researchPaper.setCiteBibtex(request.getCiteBibtex());
        researchPaper.setJournal(request.getJournal());
        researchPaper.setPages(researchPaper.getPages());
        deleteResearchPaper(researchPaper.getId());
        dataStorage.researchPapers.add(researchPaper);
        return researchPaper;
    }

    @Override
    public void deleteResearchPaper(ResearchPaperId id) {
        dataStorage.researchPapers.removeIf(researchPaper -> researchPaper.getId().equals(id));
    }

    @Override
    public List<ResearchPaper> getAllResearchPapers(Comparator<ResearchPaper> comparator) {
        var papers = dataStorage.getResearchPapers();
        papers.sort(comparator);
        return papers;
    }

    @Override
    public String getTopResearcherOfSchool(School school) {
        List<ResearchPaper> papers = new ArrayList<>();
        for (var researchPaper : dataStorage.researchPapers) {
            if (researchPaper.getSchool().equals(school)) papers.add(researchPaper);
        }
        papers.sort(new ResearchPaperComparator());
        return papers.get(0).getAuthors().get(0);
    }

    @Override
    public String getTopResearcherOfYear() {
        List<ResearchPaper> papers = dataStorage.getResearchPapers();
        papers.sort(new ResearchPaperComparator());
        return papers.get(0).getAuthors().get(0);
    }
}

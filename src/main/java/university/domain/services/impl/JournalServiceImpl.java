package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.JournalService;

public class JournalServiceImpl implements JournalService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Journal getJournal(JournalId journalId) {
        for (var journal : dataStorage.journals) {
            if (journal.getId().equals(journalId)) return journal;
        }
        return null;
    }

    @Override
    public Journal createJournal(CreateJournal request) {
        var journal = new Journal(JournalId.randomId(), request.getCurrentMarks(), request.getTranscript());
        dataStorage.journals.add(journal);
        return journal;
    }

    @Override
    public Journal updateJournal(UpdateJournal request) {
        var journal = getJournal(request.getId());
        if (journal == null) return null;
        journal.setTranscript(request.getTranscript());
        journal.setCurrentMarks(request.getCurrentMarks());
        deleteJournal(journal.getId());
        dataStorage.journals.add(journal);
        return journal;
    }

    @Override
    public void deleteJournal(JournalId journalId) {
        dataStorage.journals.removeIf(journal -> journal.getId().equals(journalId));
    }
}

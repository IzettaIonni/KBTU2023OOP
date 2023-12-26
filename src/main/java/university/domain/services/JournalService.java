package university.domain.services;

import university.domain.model.CreateJournal;
import university.domain.model.Journal;
import university.domain.model.JournalId;
import university.domain.model.UpdateJournal;

public interface JournalService {

    Journal getJournal(JournalId journalId);
    Journal createJournal(CreateJournal request);
    Journal updateJournal(UpdateJournal request);
    void deleteJournal(JournalId journalId);

}

package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Journal implements Serializable {

    @NonNull
    private final JournalId id; //same id's value as in student
    @NonNull
    List<Mark> currentMarks;
    @Nullable
    private Transcript transcript;


}

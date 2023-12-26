package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class CreateJournal {

    @NonNull
    List<Mark> currentMarks;
    @Nullable
    private Transcript transcript;

}

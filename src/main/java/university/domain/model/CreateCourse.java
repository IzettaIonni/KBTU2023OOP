package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class CreateCourse {

    @NonNull
    private final String name;
    @NonNull
    private final School school;
    @NonNull
    private Integer studentsLimit;
    @Nullable
    private List<Teacher> teachers;
    @Nullable
    private List<Student> students;
    @Nullable
    private List<Lesson> lessons;

}

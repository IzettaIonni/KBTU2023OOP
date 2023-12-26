package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdateCourse {
    @NonNull
    private final CourseId id;
    @Nullable
    private Integer studentsLimit;
    @Nullable
    private List<Teacher> teachers;
    @Nullable
    private List<Student> students;
    @Nullable
    private List<Lesson> lessons;
}

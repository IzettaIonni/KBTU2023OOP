package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.Period;

@AllArgsConstructor
@Data
@Builder
public class Lesson {

    @NonNull
    private final LessonId id;
    @NonNull
    LessonType lessonType;
    @NonNull
    Period lessonDuration;

}

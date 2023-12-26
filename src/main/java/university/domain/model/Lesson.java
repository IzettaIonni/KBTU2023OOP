package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.Period;

@AllArgsConstructor
@Data
@Builder
public class Lesson implements Serializable {

    @NonNull
    private final LessonId id;
    @NonNull
    LessonType lessonType;
    @NonNull
    Period lessonDuration;

}

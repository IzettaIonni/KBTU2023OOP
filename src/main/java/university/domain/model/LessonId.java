package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class LessonId implements Serializable {

    @NonNull
    private final UUID value;

    @JsonCreator
    public static LessonId of(@NonNull UUID value) {
        return LessonId.builder().value(value).build();
    }

    public static LessonId of(@NonNull String value) {
        return of(UUID.fromString(value));
    }

    public static LessonId randomId() {
        return of(UUID.randomUUID());
    }

    @JsonValue
    public UUID getAsUUID() {
        return getValue();
    }

    public String getAsString() {
        return getValue().toString();
    }

}

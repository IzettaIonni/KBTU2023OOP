package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder
public class CommentId {

    @NonNull
    private final UUID value;

    @JsonCreator
    public static CommentId of(@NonNull UUID value) {
        return CommentId.builder().value(value).build();
    }

    public static CommentId of(@NonNull String value) {
        return of(UUID.fromString(value));
    }

    public static CommentId randomId() {
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

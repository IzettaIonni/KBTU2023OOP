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
public class NewsId implements Serializable {

    @NonNull
    private final UUID value;

    @JsonCreator
    public static NewsId of(@NonNull UUID value) {
        return NewsId.builder().value(value).build();
    }

    public static NewsId of(@NonNull String value) {
        return of(UUID.fromString(value));
    }

    public static NewsId randomId() {
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

package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class ResearchPaperId implements Serializable {

    @NonNull
    private final UUID value;

    @JsonCreator
    public static ResearchPaperId of(@NonNull UUID value) {
        return ResearchPaperId.builder().value(value).build();
    }

    public static ResearchPaperId of(@NonNull String value) {
        return of(UUID.fromString(value));
    }

    public static ResearchPaperId randomId() {
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

package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

@Data
@Builder
public class JournalId implements Serializable {

    @NonNull
    private final String value;

    @JsonCreator
    public static JournalId of(@NonNull String value) {
        return JournalId.builder().value(value).build();
    }
    public static JournalId randomId() {
        return of(RandomStringUtils.randomAlphanumeric(9));
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}

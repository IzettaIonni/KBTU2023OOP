package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

@Builder
@Data
public class UserId implements Serializable {

    @NonNull
    private final String value;

    @JsonCreator
    public static UserId of(@NonNull String value) {
        return UserId.builder().value(value).build();
    }
    public static UserId randomId() {
        return of(RandomStringUtils.randomAlphanumeric(9));
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}

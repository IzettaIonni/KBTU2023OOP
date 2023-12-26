package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@Builder
public class CourseId {

    @NonNull
    private final String value;

    @JsonCreator
    public static CourseId of(@NonNull String value) {
        return CourseId.builder().value(value).build();
    }
    public static CourseId randomId() {
        return of(RandomStringUtils.randomAlphanumeric(6));
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}

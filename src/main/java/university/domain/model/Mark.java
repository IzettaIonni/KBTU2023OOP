package university.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

@Getter
@Data
@Builder
public class Mark implements Serializable {

    @NonNull
    private final Float value;
    public static Mark of(@NonNull Float value) {
        return Mark.builder().value(value).build();
    }

}

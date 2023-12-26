package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
@Builder(toBuilder = true)
public class UpdateAdmin {

    @NonNull
    private final UserId id;
    private final String name;
    private final String email;
    private final String password;

}

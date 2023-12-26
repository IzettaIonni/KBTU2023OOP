package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public abstract class User {

    @NonNull
    private final UserId id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

}

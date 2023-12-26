package university.domain.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Admin extends User implements Serializable {
    public Admin(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password) {
        super(id, name, email, password);
    }

}

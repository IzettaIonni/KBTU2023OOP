package university.domain.model;

import lombok.NonNull;

public class Admin extends User{
    public Admin(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password) {
        super(id, name, email, password);
    }
}

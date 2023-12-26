package university.domain.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)

public class Manager extends Employee implements Serializable {

    @NonNull
    ManagerType type;

    public Manager(@NonNull UserId id, @NonNull String name, @NonNull String email,
                   @NonNull String password, @NonNull BigDecimal salary, @NonNull ManagerType type) {
        super(id, name, email, password, salary);
        this.type = type;
    }

    public Manager(UserId id, String name, String email, String password, Integer salary, @NonNull ManagerType type) {
        this(id, name, email, password, BigDecimal.valueOf(salary), type);
    }

    public Manager(UserId id, String name, String email, String password, Float salary, @NonNull ManagerType type) {
        this(id, name, email, password, BigDecimal.valueOf(salary), type);
    }

    public Manager(UserId id, String name, String email, String password, int salary, @NonNull ManagerType type) {
        this(id, name, email, password, BigDecimal.valueOf(salary), type);
    }

    public Manager(UserId id, String name, String email, String password, float salary, @NonNull ManagerType type) {
        this(id, name, email, password, BigDecimal.valueOf(salary), type);
    }

}

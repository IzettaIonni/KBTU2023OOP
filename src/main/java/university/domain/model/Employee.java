package university.domain.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee extends User{

    @NonNull
    private BigDecimal salary;
    @Nullable
    private List<Message> messages;

    public Employee(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password, @NonNull BigDecimal salary) {
        super(id, name, email, password);
        this.salary = salary;
        messages = new ArrayList<>();
    }

    public Employee(UserId id, String name, String email, String password, Integer salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, Float salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, int salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, float salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }

}

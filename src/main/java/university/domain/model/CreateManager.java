package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class CreateManager {

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private BigDecimal salary;
    @Nullable
    private List<Message> messages;
    @NonNull
    ManagerType type;

}

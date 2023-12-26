package university.domain.model;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class UpdateManager {

    @NonNull
    private final UserId id;
    private String name;
    private String email;
    private String password;
    private BigDecimal salary;
    private List<Message> messages;
    ManagerType type;

}

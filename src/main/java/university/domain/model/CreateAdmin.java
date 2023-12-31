package university.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateAdmin {

    private final String name;
    private final String email;
    private final String password;

}

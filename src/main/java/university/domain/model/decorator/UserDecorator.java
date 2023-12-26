package university.domain.model.decorator;

import lombok.NonNull;
import university.domain.model.Researcher;
import university.domain.model.User;
import university.domain.model.UserId;

public abstract class UserDecorator extends User implements Researcher {
}

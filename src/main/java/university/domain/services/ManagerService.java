package university.domain.services;

import university.domain.model.*;

public interface ManagerService {

    Manager getManager(UserId id);
    Manager createManager(CreateManager request);
    Manager updateManager(UpdateManager request);
    void deleteManager(UserId id);

}

package university.domain.services;

import university.domain.model.Admin;
import university.domain.model.CreateAdmin;
import university.domain.model.UpdateAdmin;
import university.domain.model.UserId;

public interface AdminService {

    Admin getAdmin(UserId id);
    Admin createAdmin(CreateAdmin request);
    Admin updateAdmin(UpdateAdmin request);
    void deleteAdmin(UserId id);

}

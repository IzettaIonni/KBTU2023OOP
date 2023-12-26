package university.domain.services;

import university.domain.model.*;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(UserId id);
    Employee createEmployee(CreateEmployee request);
    Employee updateEmployee(UpdateEmployee request);
    void deleteEmployee(UserId id);
    List<Message> getMessages(UserId id);
    Message sendMessage(UserId id, Message message);

}

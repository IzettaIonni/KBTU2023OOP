package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Employee getEmployee(UserId id) {
        for (var employee : dataStorage.employees) {
            if (employee.getId().equals(id)) return employee;
        }
        return null;
    }

    @Override
    public Employee createEmployee(CreateEmployee request) {
        Employee employee;
        if (!request.getIsResearcher()) {
            employee = new Employee(UserId.randomId(), request.getName(),
                    request.getEmail(), request.getPassword(), request.getSalary());
        }
        else {
            employee = new Employee(UserId.randomId(), request.getName(),
                    request.getEmail(), request.getPassword(), request.getSalary(), request.getIsResearcher(),
                    request.getResearchPapers());
        }
        dataStorage.employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(UpdateEmployee request) {
        var employee = getEmployee(request.getId());
        if (employee == null) return null;
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setSalary(request.getSalary());
        employee.setMessages(request.getMessages());
        employee.setIsResearcher(request.getIsResearcher());
        employee.setResearchPapers(request.getResearchPapers());
        deleteEmployee(employee.getId());
        dataStorage.employees.add(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(UserId id) {
        dataStorage.employees.removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public List<Message> getMessages(UserId id) {
        var employee = getEmployee(id);
        if (employee == null) return null;
        return employee.getMessages();
    }

    @Override
    public Message sendMessage(UserId id, Message message) {
        var employee = getEmployee(id);
        if (employee == null) return null;
        var messages = employee.getMessages();
        messages.add(message);
        employee.setMessages(messages);
        return message;
    }
}

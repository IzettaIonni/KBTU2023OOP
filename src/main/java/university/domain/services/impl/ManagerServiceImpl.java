package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Manager getManager(UserId id) {
        for (var manager : dataStorage.managers) {
            if (manager.getId().equals(id)) return manager;
        }
        return null;
    }

    @Override
    public Manager createManager(CreateManager request) {
        var manager = new Manager(UserId.randomId(), request.getName(), request.getEmail(), request.getPassword(),
                request.getSalary(), request.getType());
        dataStorage.managers.add(manager);
        return manager;
    }

    @Override
    public Manager updateManager(UpdateManager request) {
        var manager = getManager(request.getId());
        if (manager == null) return null;
        manager.setEmail(request.getEmail());
        manager.setName(request.getName());
        manager.setPassword(request.getPassword());
        deleteManager(manager.getId());
        dataStorage.managers.add(manager);
        return manager;
    }

    @Override
    public void deleteManager(UserId id) {
        dataStorage.managers.removeIf(manager -> manager.getId().equals(id));
    }
}

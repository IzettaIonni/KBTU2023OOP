package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.AdminService;

import javax.xml.crypto.Data;

public class AdminServiceImpl implements AdminService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Admin getAdmin(UserId id) {
        for (var admin : dataStorage.admins) {
            if (admin.getId().equals(id)) return admin;
        }
        return null;
    }

    @Override
    public Admin createAdmin(CreateAdmin request) {
        var admin = new Admin(UserId.randomId(), request.getName(), request.getEmail(), request.getPassword());
        dataStorage.admins.add(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(UpdateAdmin request) {
        var admin = getAdmin(request.getId());
        if (admin == null) return null;
        admin.setEmail(request.getEmail());
        admin.setName(request.getName());
        admin.setPassword(request.getPassword());
        deleteAdmin(admin.getId());
        dataStorage.admins.add(admin);
        return admin;
    }

    @Override
    public void deleteAdmin(UserId id) {
        dataStorage.admins.removeIf(admin -> admin.getId().equals(id));
    }
}

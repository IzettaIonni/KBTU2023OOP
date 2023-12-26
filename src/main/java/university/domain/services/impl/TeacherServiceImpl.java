package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.exceptions.MustBeResearcherException;
import university.domain.model.*;
import university.domain.services.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Teacher getTeacher(UserId id) {
        for (var teacher : dataStorage.teachers) {
            if (teacher.getId().equals(id)) return teacher;
        }
        return null;
    }

    @Override
    public Teacher createTeacher(CreateTeacher request) throws MustBeResearcherException {
        Teacher teacher;
        if (!request.getIsResearcher()) {
            teacher = new Teacher(UserId.randomId(), request.getName(),
                    request.getEmail(), request.getPassword(), request.getSalary(), request.getSchool(), request.getTeacherType(), request.getGraduate());
        }
        else {
            teacher = new Teacher(UserId.randomId(), request.getName(),
                    request.getEmail(), request.getPassword(), request.getSalary(),
                    request.getSchool(), request.getTeacherType(), request.getGraduate(), request.getIsResearcher(),
                    request.getResearchPapers());
        }
        dataStorage.employees.add(teacher);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(UpdateTeacher request) {
        var teacher = getTeacher(request.getId());
        if (teacher == null) return null;
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setPassword(request.getPassword());
        teacher.setSalary(request.getSalary());
        teacher.setMessages(request.getMessages());
        teacher.setIsResearcher(request.getIsResearcher());
        teacher.setResearchPapers(request.getResearchPapers());
        teacher.setTeacherType(request.getTeacherType());
        teacher.setSchool(request.getSchool());
        teacher.setGraduate(request.getGraduate());
        deleteTeacher(teacher.getId());
        dataStorage.employees.add(teacher);
        return teacher;
    }

    @Override
    public void deleteTeacher(UserId id) {
        dataStorage.teachers.removeIf(teacher -> teacher.getId().equals(id));
    }
}

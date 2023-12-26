package university.domain.services;

import university.domain.model.CreateTeacher;
import university.domain.model.Teacher;
import university.domain.model.UpdateTeacher;
import university.domain.model.UserId;

public interface TeacherService {

    Teacher getTeacher(UserId id);
    Teacher createTeacher(CreateTeacher request);
    Teacher updateTeacher(UpdateTeacher request);
    void deleteTeacher(UserId id);

}

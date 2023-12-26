package university.domain.services;

import university.domain.model.*;

import java.util.List;

public interface CourseService {

    Course getCourse(CourseId id);
    Course createCourse(CreateCourse request);
    Course updateCourse(UpdateCourse request);
    void deleteCourse(CourseId id);

}

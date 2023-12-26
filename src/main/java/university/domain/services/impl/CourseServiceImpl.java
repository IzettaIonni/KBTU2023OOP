package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public Course getCourse(CourseId id) {
        for (var course : dataStorage.courses) {
            if (course.getId().equals(id)) return course;
        }
        return null;
    }

    @Override
    public Course createCourse(CreateCourse request) {
        var course = Course.builder()
                .id(CourseId.randomId())
                .name(request.getName())
                .school(request.getSchool())
                .studentsLimit(request.getStudentsLimit())
                .teachers(request.getTeachers())
                .students(request.getStudents())
                .lessons(request.getLessons())
                .build();
        dataStorage.courses.add(course);
        return course;
    }

    @Override
    public Course updateCourse(UpdateCourse request) {
        var course = getCourse(request.getId());
        if (course == null) return null;
        course.setLessons(request.getLessons());
        course.setStudents(request.getStudents());
        course.setTeachers(request.getTeachers());
        course.setStudentsLimit(request.getStudentsLimit());
        deleteCourse(course.getId());
        dataStorage.courses.add(course);
        return course;
    }

    @Override
    public void deleteCourse(CourseId id) {
        dataStorage.courses.removeIf(course -> course.getId().equals(id));
    }
}

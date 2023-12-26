package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Course {

    @NonNull
    private final CourseId id;
    @NonNull
    private final String name;
    @NonNull
    private final School school;
    @NonNull
    private Integer studentsLimit;
    @Nullable
    private List<Teacher> teachers;
    @Nullable
    private List<Student> students;
    @Nullable
    private List<Lesson> lessons;

    public Course(@NonNull CourseId id, @NonNull String name, @NonNull School school,
                  @NonNull Integer studentsLimit, @Nullable List<Teacher> teachers,
                  @Nullable List<Student> students, @Nullable List<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.studentsLimit = studentsLimit;
        if (teachers != null) this.teachers = teachers;
        else this.teachers = new ArrayList<>();
        if (students != null) this.students = students;
        else this.students = new ArrayList<>();
        if (lessons != null) this.lessons = lessons;
        else this.lessons = new ArrayList<>();
    }
    public Course(CourseId id, String name, School school, Integer studentsLimit) {
        this(id, name, school, studentsLimit, null, null, null);
    }
}

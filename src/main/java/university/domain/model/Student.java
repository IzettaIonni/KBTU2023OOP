package university.domain.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student extends User{

    @NonNull
    private School school;
    @NonNull
    private Integer course;

    public Student(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull School school, @NonNull Integer course) {
        super(id, name, email, password);
        this.school = school;
        this.course = course;
    }

}

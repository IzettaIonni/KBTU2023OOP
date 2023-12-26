package university.domain.model;

import lombok.NonNull;

import java.math.BigDecimal;

public class Teacher extends Employee{

    @NonNull
    School school;
    @NonNull
    TeacherType teacherType;

    public Teacher(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull BigDecimal salary, @NonNull School school, @NonNull TeacherType teacherType) {
        super(id, name, email, password, salary);
    }

    public Teacher(UserId id, String name, String email, String password, Integer salary, School school, TeacherType teacherType) {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType);
    }

    public Teacher(UserId id, String name, String email, String password, Float salary, School school, TeacherType teacherType) {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType);
    }

    public Teacher(UserId id, String name, String email, String password, int salary, School school, TeacherType teacherType) {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType);
    }

    public Teacher(UserId id, String name, String email, String password, float salary, School school, TeacherType teacherType) {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType);
    }
}

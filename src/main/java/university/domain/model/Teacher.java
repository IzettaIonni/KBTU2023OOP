package university.domain.model;

import lombok.*;
import university.domain.exceptions.MustBeResearcherException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Teacher extends Employee implements Serializable {

    @NonNull
    private School school;
    @NonNull
    private TeacherType teacherType;
    @NonNull
    private Graduate graduate;
    private Boolean isResearcher;
    private List<ResearchPaper> researchPapers;

    public Teacher(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull BigDecimal salary, @NonNull School school, @NonNull TeacherType teacherType, @NonNull Graduate graduate) throws MustBeResearcherException {
        super(id, name, email, password, salary);
        if (graduate != Graduate.BACHELOR && graduate != Graduate.ABSENT) throw new MustBeResearcherException();
        this.graduate = graduate;
        this.isResearcher = Boolean.FALSE;
    }

    public Teacher(UserId id, String name, String email, String password, Integer salary, School school, TeacherType teacherType, Graduate graduate) throws MustBeResearcherException {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType, graduate);
    }

    public Teacher(UserId id, String name, String email, String password, Float salary, School school, TeacherType teacherType, Graduate graduate) throws MustBeResearcherException {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType, graduate);
    }

    public Teacher(UserId id, String name, String email, String password, int salary, School school, TeacherType teacherType, Graduate graduate) throws MustBeResearcherException {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType, graduate);
    }

    public Teacher(UserId id, String name, String email, String password, float salary, School school, TeacherType teacherType, Graduate graduate) throws MustBeResearcherException {
        this(id, name, email, password, BigDecimal.valueOf(salary), school, teacherType, graduate);
    }

    public Teacher(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull BigDecimal salary, @NonNull School school, @NonNull TeacherType teacherType, @NonNull Graduate graduate,
                   Boolean isResearcher, List<ResearchPaper> researchPapers) {
        super(id, name, email, password, salary);
        this.isResearcher = true;
        this.researchPapers = researchPapers;
    }

    @Override
    public List<ResearchPaper> printPapers(Comparator<ResearchPaper> comparator) {
        return researchPapers;
    }

    @Override
    public Integer getHIndex() {
        return researchPapers.size();
    }
}

package university.domain.model;

import lombok.*;
import university.domain.exceptions.MustBeResearcherException;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Student extends User implements Researcher, Serializable {

    @NonNull
    private School school;
    @NonNull
    private Integer course;
    @NonNull
    private Graduate graduate;
    private Boolean isResearcher;
    private List<ResearchPaper> researchPapers;

    public Student(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull School school, @NonNull Integer course, @NonNull Graduate graduate) throws MustBeResearcherException {
        super(id, name, email, password);
        this.school = school;
        this.course = course;
        if (graduate != Graduate.BACHELOR && graduate != Graduate.ABSENT) throw new MustBeResearcherException();
        this.graduate = graduate;
        this.isResearcher = Boolean.FALSE;
    }

    public Student(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password,
                   @NonNull School school, @NonNull Integer course, Boolean isResearcher, List<ResearchPaper> researchPapers, @NonNull Graduate graduate) {
        super(id, name, email, password);
        this.school = school;
        this.course = course;
        this.graduate = graduate;
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

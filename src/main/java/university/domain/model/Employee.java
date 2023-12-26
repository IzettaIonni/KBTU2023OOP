package university.domain.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class Employee extends User implements Researcher, Serializable {

    @NonNull
    private BigDecimal salary;
    @Nullable
    private List<Message> messages;
    private Boolean isResearcher;
    private List<ResearchPaper> researchPapers;

    public Employee(@NonNull UserId id, @NonNull String name, @NonNull String email, @NonNull String password, @NonNull BigDecimal salary) {
        super(id, name, email, password);
        this.salary = salary;
        messages = new ArrayList<>();
        this.isResearcher = Boolean.FALSE;
    }

    public Employee(UserId id, String name, String email, String password, Integer salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, Float salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, int salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }
    public Employee(UserId id, String name, String email, String password, float salary) {
        this(id, name, email, password, BigDecimal.valueOf(salary));
    }

    public Employee(@NonNull UserId id, @NonNull String name, @NonNull String email,
                    @NonNull String password, @NonNull BigDecimal salary, Boolean isResearcher, List<ResearchPaper> researchPapers) {
        super(id, name, email, password);
        this.salary = salary;
        messages = new ArrayList<>();
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

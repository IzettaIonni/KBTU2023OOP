package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder(toBuilder = true)
public class UpdateTeacher {

    @NonNull
    private final UserId id;
    private String name;
    private String email;
    private String password;
    private BigDecimal salary;
    private List<Message> messages;
    private Boolean isResearcher;
    private List<ResearchPaper> researchPapers;
    private School school;
    private TeacherType teacherType;
    private Graduate graduate;

}

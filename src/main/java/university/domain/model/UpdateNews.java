package university.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Builder
public class UpdateNews {

    @NonNull
    private final NewsId id;
    @Nullable
    private final String title;
    @Nullable
    private final String body;
    @Nullable
    private final Integer priority;
    @Nullable
    private final List<Comment> comments;
    @Nullable
    private final UserType usersToNotify;

    public UpdateNews(@NonNull NewsId id, @Nullable String title, @Nullable String body, @Nullable Integer priority, @Nullable List<Comment> comments, @Nullable UserType usersToNotify) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.comments = comments;
        this.usersToNotify = usersToNotify;
    }
}

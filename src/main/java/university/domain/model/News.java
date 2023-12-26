package university.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Builder
@Data
public class News implements Cloneable{

    @NonNull
    private final NewsId id;
    @NonNull
    private String title;
    @NonNull
    private String body;
    @NonNull
    private LocalDateTime publicationDate;
    @NonNull
    private Integer priority;
    @NonNull
    private List<Comment> comments;
    @Nullable
    private UserType usersToNotify;

    public News(@NonNull NewsId id, @NonNull String title, @NonNull String body, @NonNull LocalDateTime publicationDate, @NonNull Integer priority, @Nullable List<Comment> comments, @Nullable UserType usersToNotify) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.publicationDate = publicationDate;
        this.priority = priority;
        if (comments != null) this.comments = comments;
        else this.comments = new ArrayList<>();
        this.usersToNotify = usersToNotify;
    }

    public News(NewsId id, String title, String body, Integer priority, List<Comment> comments, UserType usersToNotify) {
        this(id, title, body, LocalDateTime.now(), priority, comments, usersToNotify);
    }
    public News(NewsId id, String title, String body, LocalDateTime publicationDate, Integer priority, UserType usersToNotify) {
        this(id, title, body, publicationDate, priority, new ArrayList<>(), usersToNotify);
    }
    public News(NewsId id, String title, String body, Integer priority, UserType usersToNotify) {
        this(id, title, body, LocalDateTime.now(), priority, new ArrayList<>(), usersToNotify);
    }
    public News(String title, String body, Integer priority, List<Comment> comments, UserType usersToNotify) {
        this(NewsId.randomId(), title, body, LocalDateTime.now(), priority, comments, usersToNotify);
    }
    public News(String title, String body, LocalDateTime publicationDate, Integer priority, UserType usersToNotify) {
        this(NewsId.randomId(), title, body, publicationDate, priority, new ArrayList<>(), usersToNotify);
    }
    public News(String title, String body, Integer priority, UserType usersToNotify) {
        this(NewsId.randomId(), title, body, LocalDateTime.now(), priority, new ArrayList<>(), usersToNotify);
    }

    @Override
    public News clone() {
        try {
            News clone = (News) super.clone();
            clone.setComments(List.copyOf(comments));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

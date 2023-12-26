package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
public class Comment implements Cloneable, Serializable {

    @NonNull
    private final CommentId id;
    @NonNull
    private final UserId author;
    @NonNull
    private final String body;
    @NonNull
    private Integer likes;

    public Comment(@NonNull CommentId id, @NonNull UserId author, @NonNull String body, @NonNull Integer likes) {
        this.id = id;
        this.author = author;
        this.body = body;
        this.likes = likes;
    }

    public Comment(@NonNull CommentId id, @NonNull UserId author, @NonNull String body) {
        this(id, author, body, 0);
    }

    public void putLike() {
        likes += 1;
    }

    @Override
    public Comment clone() {
        try {
            Comment clone = (Comment) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}

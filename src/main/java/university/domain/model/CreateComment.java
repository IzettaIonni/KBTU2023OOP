package university.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Builder
@Getter
public class CreateComment {

    @NonNull
    private final UserId author;
    @NonNull
    private final String body;
    @Nullable
    private final Integer likes;

    public CreateComment(@NonNull UserId author, @NonNull String body, @Nullable Integer likes) {
        this.author = author;
        this.body = body;
        if (likes != null) this.likes = likes;
        else this.likes = 0;
    }
}

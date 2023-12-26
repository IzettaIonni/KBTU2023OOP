package university.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import net.bytebuddy.asm.Advice;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Builder
public class CreateNews {

    @NonNull
    private final String title;
    @NonNull
    private final String body;
    @NonNull
    private final Integer priority;
    @Nullable
    private final UserType usersToNotify;

    public CreateNews(@NonNull String title, @NonNull String body, @NonNull Integer priority, @Nullable UserType usersToNotify) {
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.usersToNotify = usersToNotify;
    }
}

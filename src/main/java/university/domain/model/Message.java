package university.domain.model;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Message implements Serializable {

    @NonNull
    private final UserId sender;
    @NonNull
    private final String body;
    @NonNull
    private final LocalDateTime sendTime;

    public Message(@NonNull UserId sender, @NonNull String body) {
        this.sender = sender;
        this.body = body;
        this.sendTime = LocalDateTime.now();
    }
}

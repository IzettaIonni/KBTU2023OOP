package university.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class NewsSimple implements Cloneable {

    private final String title;
    private final String body;
    private final LocalDateTime publicationDate;
    private final Integer priority;
    private List<Comment> comments;
    private List<UserId> usersToNotify;

    public NewsSimple(String title, String body, LocalDateTime publicationDate, Integer priority,
                      List<Comment> comments, List<UserId> usersToNotify) {
        this.title = title;
        this.body = body;
        this.publicationDate = publicationDate;
        this.priority = priority;
        this.comments = comments;
        this.usersToNotify = usersToNotify;
    }

    public NewsSimple(String title, String body, Integer priority, List<Comment> comments, List<UserId> usersToNotify) {
        this(title, body, LocalDateTime.now(), priority, comments, usersToNotify);
    }
    public NewsSimple(String title, String body, LocalDateTime publicationDate, Integer priority, List<UserId> usersToNotify) {
        this(title, body, publicationDate, priority, new ArrayList<>(), usersToNotify);
    }
    public NewsSimple(String title, String body, Integer priority, List<UserId> usersToNotify) {
        this(title, body, LocalDateTime.now(), priority, new ArrayList<>(), usersToNotify);
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<UserId> getUsersToNotify() {
        return usersToNotify;
    }

    public void setUsersToNotify(List<UserId> usersToNotify) {
        this.usersToNotify = usersToNotify;
    }

    @Override
    public String toString() {
        return "NewsSimple{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", publicationDate=" + publicationDate +
                ", priority=" + priority +
                ", comments=" + comments +
                ", usersToNotify=" + usersToNotify +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsSimple that = (NewsSimple) o;
        return Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(publicationDate, that.publicationDate) && Objects.equals(priority, that.priority) && Objects.equals(comments, that.comments) && Objects.equals(usersToNotify, that.usersToNotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, publicationDate, priority, comments, usersToNotify);
    }

    @Override
    public NewsSimple clone() {
        try {
            NewsSimple clone = (NewsSimple) super.clone();
            clone.setComments(List.copyOf(comments));
            clone.setUsersToNotify(List.copyOf(usersToNotify));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

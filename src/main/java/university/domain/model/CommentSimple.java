package university.domain.model;

import java.util.Objects;

public class CommentSimple {

    private final UserId author;
    private final String body;
    private Integer likes;

    public CommentSimple(UserId author, String body, Integer likes) {
        this.author = author;
        this.body = body;
        this.likes = likes;
    }

    public CommentSimple(UserId author, String body) {
        this(author, body, 0);
    }

    public void putLike() {
        likes += 1;
    }

    public UserId getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "CommentSimple{" +
                "author=" + author +
                ", body='" + body + '\'' +
                ", likes=" + likes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentSimple that = (CommentSimple) o;
        return Objects.equals(author, that.author) && Objects.equals(body, that.body) && Objects.equals(likes, that.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, body, likes);
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

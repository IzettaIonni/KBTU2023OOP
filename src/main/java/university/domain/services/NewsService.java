package university.domain.services;

import org.springframework.lang.Nullable;
import university.domain.model.*;

import java.util.List;

public interface NewsService {

    News getNews(NewsId newsId);
    List<News> getLastNews();
    News createNews(CreateNews request);
    News updateNews(UpdateNews request);
    void deleteNews(NewsId newsId);
    List<Comment> getComments(NewsId newsId);
    Comment addComment(NewsId newsId, CreateComment request);
    void addLikes(NewsId newsId, CommentId commentId, Integer likes);
    void deleteComment(NewsId newsid, CommentId commentId);

}

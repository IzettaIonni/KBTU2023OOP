package university.domain.services.impl;

import university.datastorage.DataStorage;
import university.domain.model.*;
import university.domain.services.NewsService;

import java.time.LocalDateTime;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private static final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    public News getNews(NewsId newsId) {
        for (var news : dataStorage.news) {
            if (news.getId().equals(newsId)) return news;
        }
        return null;
    }

    @Override
    public List<News> getLastNews() {
        return dataStorage.getNews();
    }

    @Override
    public News createNews(CreateNews request) {
        var news = new News(NewsId.randomId(), request.getTitle(), request.getBody(), LocalDateTime.now(),
                request.getPriority(), null, null);
        dataStorage.news.add(news);
        return news;
    }

    @Override
    public News updateNews(UpdateNews request) {
        var news = getNews(request.getId());
        if (news == null) return null;
        news.setTitle(request.getTitle());
        news.setBody(request.getBody());
        news.setPublicationDate(LocalDateTime.now());
        news.setPriority(request.getPriority());
        news.setComments(request.getComments());
        news.setUsersToNotify(request.getUsersToNotify());
        deleteNews(news.getId());
        dataStorage.news.add(news);
        return news;
    }

    @Override
    public void deleteNews(NewsId newsId) {
        dataStorage.news.removeIf(news -> news.getId().equals(news));
    }

    @Override
    public List<Comment> getComments(NewsId newsId) {
        var news = getNews(newsId);
        if (news == null) return null;
        return news.getComments();
    }

    @Override
    public Comment addComment(NewsId newsId, CreateComment request) {
        var news = getNews(newsId);
        if (news == null) return null;
        var comment = new Comment(CommentId.randomId(), request.getAuthor(), request.getBody(), request.getLikes());
        news.getComments().add(comment);
        deleteNews(newsId);
        dataStorage.news.add(news);
        return comment;
    }

    @Override
    public void addLikes(NewsId newsId, CommentId commentId, Integer likes) {

    }

    @Override
    public void deleteComment(NewsId newsid, CommentId commentId) {

    }
}

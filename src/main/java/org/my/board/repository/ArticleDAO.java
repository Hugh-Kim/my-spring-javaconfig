package org.my.board.repository;

import org.my.board.model.Article;

import java.util.List;

/**
 * Created by thkim1 on 2016. 9. 12..
 */
public interface ArticleDAO {
    List<Article> getArticleList();

    Article getArticleDetail(int seqNo);

    void saveArticle(Article article);
}

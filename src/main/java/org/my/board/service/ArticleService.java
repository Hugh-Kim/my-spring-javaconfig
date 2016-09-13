package org.my.board.service;

import org.my.board.model.Article;

import java.util.List;

/**
 * Created by thkim1 on 2016. 9. 12..
 */
public interface ArticleService {
	List<Article> getArticleList();

	Article getArticleDetail(int seqNo);

	void saveArticle(Article article);
}

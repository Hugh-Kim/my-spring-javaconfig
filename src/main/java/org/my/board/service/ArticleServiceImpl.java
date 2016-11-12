package org.my.board.service;

import org.my.board.model.Article;
import org.my.board.repository.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thkim1 on 2016. 9. 12..
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public List<Article> getArticleList() {
		return articleDAO.getArticleList();
	}

	@Override
	public Article getArticleDetail(int seqNo) {
		return articleDAO.getArticleDetail(seqNo);
	}

	@Override
	public void saveArticle(Article article) {
		articleDAO.saveArticle(article);
	}
}

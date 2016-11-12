package org.my.board.repository;

import org.hibernate.SessionFactory;
import org.my.board.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by thkim1 on 2016. 9. 12..
 */
@Repository
public class ArticleDAOImpl implements ArticleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getArticleList() {
		EntityManager entityManager = sessionFactory.createEntityManager();

		CriteriaQuery<Article> query = entityManager
				.getCriteriaBuilder()
				.createQuery(Article.class);

		Root<Article> fromArticle = query.from(Article.class);
		CriteriaQuery<Article> select = query.select(fromArticle);

		return entityManager.createQuery(select).getResultList();
	}

	@Override
	public Article getArticleDetail(int seqNo) {
		EntityManager entityManager = sessionFactory.createEntityManager();

		CriteriaQuery<Article> query = entityManager.getCriteriaBuilder()
				.createQuery(Article.class);

		Root<Article> fromArticle = query.from(Article.class);
		CriteriaQuery<Article> select = query.select(fromArticle)
				.where(sessionFactory.getCriteriaBuilder().equal(fromArticle.get("seqNo"), seqNo));

		return entityManager.createQuery(select).getSingleResult();
	}

	@Override
	public void saveArticle(Article article) {
		EntityManager entityManager = sessionFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(article);
		transaction.commit();

	}
}

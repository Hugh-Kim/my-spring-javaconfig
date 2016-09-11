package org.my.board.repository;

import org.hibernate.SessionFactory;
import org.my.board.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by HughKim on 2016-09-11.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Root<User> fromUser = sessionFactory.getCriteriaBuilder()
                .createQuery(User.class)
                .from(User.class);

        CriteriaQuery<User> select = sessionFactory.getCriteriaBuilder()
                .createQuery(User.class)
                .select(fromUser);

        List<User> resultList = sessionFactory.createEntityManager().createQuery(select).getResultList();
        return resultList;
    }
}

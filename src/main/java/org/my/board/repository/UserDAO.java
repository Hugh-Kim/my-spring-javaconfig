package org.my.board.repository;

import org.my.board.model.User;

import java.util.List;

/**
 * Created by HughKim on 2016-09-11.
 */
public interface UserDAO {
    List<User> getUsers();
}

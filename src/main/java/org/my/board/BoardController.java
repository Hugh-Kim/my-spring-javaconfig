package org.my.board;

import lombok.extern.slf4j.Slf4j;
import org.my.board.model.Article;
import org.my.board.model.User;
import org.my.board.repository.UserDAO;
import org.my.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by home on 2016-09-10.
 */
@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ModelAndView boardIndex() {
        ModelAndView modelAndView = new ModelAndView("boardList");

        List<User> users = userDAO.getUsers();
        modelAndView.addObject("users", users);

        List<Article> articleList = articleService.getArticleList();
        modelAndView.addObject("articleList", articleList);

        return modelAndView;
    }

}

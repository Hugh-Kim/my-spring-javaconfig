package org.my.board;

import lombok.extern.slf4j.Slf4j;
import org.my.board.model.User;
import org.my.board.repository.UserDAO;
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

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ModelAndView boardIndex() {
        ModelAndView modelAndView = new ModelAndView("boardList");

        List<User> users = userDAO.getUsers();
        modelAndView.addObject("users", users);

        return modelAndView;
    }
}

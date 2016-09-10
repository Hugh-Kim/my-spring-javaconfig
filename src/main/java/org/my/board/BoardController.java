package org.my.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by home on 2016-09-10.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ModelAndView boardIndex() {
        ModelAndView modelAndView = new ModelAndView("boardList");

        return modelAndView;
    }
}

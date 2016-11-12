package org.my.board;

import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang.builder.ToStringBuilder;
import org.my.board.model.Article;
import org.my.board.model.User;
import org.my.board.repository.UserDAO;
import org.my.board.service.ArticleService;
import org.my.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ModelAndView articleList() {
        ModelAndView modelAndView = new ModelAndView("articleList");

        List<Article> articleList = articleService.getArticleList();
        modelAndView.addObject("articleList", articleList);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articleDetail/{seqNo}")
    public ModelAndView articleDetail(@PathVariable int seqNo) {
        ModelAndView modelAndView = new ModelAndView("articleDetail");
        Article article = articleService.getArticleDetail(seqNo);

        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ModelAndView saveArticle(Article article) {
        log.info(ToStringBuilder.reflectionToString(article));

        ModelAndView modelAndView = new ModelAndView("redirect:/board/list");
        articleService.saveArticle(article);

        return modelAndView;
    }

}

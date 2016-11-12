package org.my.study.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.my.board.BoardController;
import org.my.board.model.Article;
import org.my.board.repository.UserDAO;
import org.my.board.service.ArticleService;
import org.my.study.StudyViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by HughKim on 2016-11-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                ScriptTemplateViewResolverConfig.class
                , StudyViewController.class
                , BoardController.class
        }
)
@WebAppConfiguration
public class StudyViewControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void name() throws Exception {
        mvc.perform(get("/test/alert"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void callInternalView() throws Exception {
        mvc.perform(get("/board/list"))
                .andDo(print())
                .andExpect(status().isOk())
        ;

    }
}

@Configuration
class ScriptTemplateViewResolverConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF/view/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setOrder(2);
        return internalResourceViewResolver;
    }

    @Bean
    public ScriptTemplateViewResolver scriptTemplateViewResolver() {
        ScriptTemplateViewResolver scriptTemplateViewResolver = new ScriptTemplateViewResolver();
        scriptTemplateViewResolver.setPrefix("/WEB-INF/view/template/");
        scriptTemplateViewResolver.setSuffix(".html");
        scriptTemplateViewResolver.setViewNames("alert");
        scriptTemplateViewResolver.setOrder(1);
        return scriptTemplateViewResolver;
    }

    @Bean
    public ScriptTemplateConfig scriptTemplateConfig() {
        ScriptTemplateConfigurer scriptTemplateConfigurer = new ScriptTemplateConfigurer();
        scriptTemplateConfigurer.setEngineName("nashorn");
        scriptTemplateConfigurer.setRenderFunction("render");
        scriptTemplateConfigurer.setScripts("/WEB-INF/view/template/render.js");
        return scriptTemplateConfigurer;
    }

    @Bean
    public UserDAO userDAO() {
        return mock(UserDAO.class);
    }

    @Bean
    public ArticleService articleService() {
        return mock(ArticleService.class);
    }
}
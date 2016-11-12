package org.my.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.my.board.service.ArticleService;
import org.my.board.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by home on 2016-09-10.
 */
@RunWith(MockitoJUnitRunner.class)
public class BoardControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    @Mock
    private ArticleService articleService;

    @InjectMocks
    private BoardController boardController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void boardIndex() throws Exception {
        mockMvc.perform(get("/board/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("articleList"))
        ;
    }

    @Test
    public void get_contents_detail_with_seqNo() throws Exception {
        mockMvc.perform(get("/board/articleDetail/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("articleDetail"))
                ;
    }

    @Test
    public void save_article() throws Exception {
        mockMvc.perform(post("/board/save")
                .param("seqNo", "13")
                .param("title", "testArticle Title")
                .param("content", "test article content"))
                .andDo(print())
                .andExpect(status().isFound())
                ;

    }
}

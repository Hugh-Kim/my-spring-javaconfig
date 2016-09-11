package org.my.board;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by home on 2016-09-10.
 */
public class BoardControllerTest {
    private MockMvc mockMvc;
    private BoardController boardController;

    @Before
    public void setUp() throws Exception {
        this.boardController = new BoardController();
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void boardIndex() throws Exception {
        mockMvc.perform(get("/board/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("boardList"))
        ;
    }

}

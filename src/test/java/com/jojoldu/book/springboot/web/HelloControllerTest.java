package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.jojoldu.book.springboot.web.HelloController;

@RunWith(SpringRunner.class)                        // JUnit 실행자 대신 다른 실행자
@WebMvcTest(controllers = HelloController.class)    //
public class HelloControllerTest {

    @Autowired  // bean을 주입받는다. bean이란? IoC가 관리하는 앱의 backbone
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
           .andExpect(status().isOk())
           .andExpect(content().string(hello));
    }

    @Test
    public void HelloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.name", is(name)))
           .andExpect(jsonPath("$.amount", is(amount)));

    }
}

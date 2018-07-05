package com.java;

import com.java.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReadinglistApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/readingList"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(empty())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(post("/readingList")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "BOOK TITLE")
                .param("author", "BOOK AUTHOR")
                .param("isbn", "1234567890")
                .param("description", "DESCRIPTION"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/readingList"));

        Book book = new Book();
        book.setId(1L);
        book.setReader("craig");
        book.setTitle("BOOK TITLE");
        book.setAuthor("BOOK AUTHOR");
        book.setIsbn("1234567890");
        book.setDescription("DESCRIPTION");

//        mockMvc.perform(get("/readingList"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("readingList"))
//                .andExpect(model().attributeExists("books"))
//                .andExpect(model().attribute("books", hasSize(1)))
//                .andExpect(model().attribute("books",
//                        contains(samePropertyValuesAs(book))));
    }

}

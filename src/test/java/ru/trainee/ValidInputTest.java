package ru.trainee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("sensor")
public class ValidInputTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void invalidNumberTest() throws Exception {
        this.mockMvc.perform(post("/saveInput")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("x", "text"))
                .andDo(print())
                .andExpect(xpath("//*[@class='error']").string("Invalid number format for coordinate x"));
    }

    @Test
    public void inRangeTest() throws Exception {
        this.mockMvc.perform(post("/saveInput")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("temperature", "40.5"))
                .andDo(print())
                .andExpect(xpath("//*[@class='error']").string("Temperature must be in range of 10 to 30"));
    }

    @Test
    public void successSaveTest() throws Exception {
        this.mockMvc.perform(post("/saveInput")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("x", "40.5")
                .param("y", "21,5")
                .param("temperature", "22.14"))
                .andDo(print())
                .andExpect(xpath("//*[@class='error']").string(""));
    }
}

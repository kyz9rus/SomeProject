package ru.trainee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.trainee.controllers.MainController;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("sensor")
public class SensorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MainController mainController;

    @Test
    public void sensorPageTest() throws Exception {
        this.mockMvc.perform(get("/sensorPage"))
                .andDo(print())
                .andExpect(authenticated());
    }

    @Test
    public void notUserPageTest() throws Exception {
        this.mockMvc.perform(get("/userPage"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void getInputsTest() throws Exception {
        this.mockMvc.perform(get("/get-inputs"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}

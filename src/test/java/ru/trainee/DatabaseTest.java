package ru.trainee;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.trainee.model.Input;
import ru.trainee.repository.InputRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application.properties")
public class DatabaseTest {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkSavingInput() throws Exception {
        int initialSize = inputRepository.findAll().size();

        Input input = new Input(9, 22.1, 4.2, 2.1);
        inputRepository.save(input);

        int currentSize = inputRepository.findAll().size();

        assertThat(currentSize == initialSize + 1);
    }

    // assert true only when we have 20 inputs in table in database. It depends on SQL code in file insert-input-after (we can restart sequence restart with <number>, we can't depend with variable or current sequence value)
    @WithUserDetails("user")
    @Sql(value = {"/insert-input-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/insert-input-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void checkDisplayInputInTable() throws Exception {
        this.mockMvc.perform(get("/get-inputs"))
                .andExpect(xpath("(//td[@class='temperature'])[last()]").string("10.2299995"));
    }

    @Test
    public void checkIncorrectSavingInput() {
        try {
            Input input = new Input(2.1, 4.2, 2.5);
            inputRepository.save(input);
        } catch (Exception e) {
            assertThat(true);
        }
    }
}


package dc.rest.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by david on 12.07.2018.
 */
@RunWith(SpringRunner.class)
public class ApiRestControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiRestController()).setControllerAdvice(new RestControllerAdvice()).build();
        objectMapper = new ObjectMapper();
    }
}

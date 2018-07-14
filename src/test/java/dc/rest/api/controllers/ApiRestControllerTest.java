package dc.rest.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * Created by david on 12.07.2018.
 */
@RunWith(SpringRunner.class)
public class ApiRestControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void givenAGetRequestToServicesUriAndAListOfServices_whenGetServicesIsCalled_thenReturnListOfExistingServices() throws Exception {
        //given
        ArrayList<String> services = new ArrayList<String>();
        services.add("service1");
        services.add("service2");
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiRestController<ArrayList<String>>(services)).setControllerAdvice(new RestControllerAdvice()).build();
        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/services")).andReturn().getResponse();
        //then
        System.out.println(objectMapper.writeValueAsString(services) + " ::: " + response.getContentAsString());
        assertEquals(objectMapper.writeValueAsString(services), response.getContentAsString());
    }

    @Test
    public void givenAGetRequestToServicesUriAndANullObject_whenGetServicesIsCalled_thenReturnErrorObject() throws Exception {
        //given
        ServiceNotFoundException e = new ServiceNotFoundException();
        String[] error = {e.getMessage(), HttpStatus.NOT_FOUND.toString()};
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiRestController<Object>(null)).setControllerAdvice(new RestControllerAdvice()).build();
        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/services")).andReturn().getResponse();
        //then
        System.out.println(objectMapper.writeValueAsString(error) + " ::: " + response.getContentAsString());
        assertEquals(objectMapper.writeValueAsString(error), response.getContentAsString());
    }
}

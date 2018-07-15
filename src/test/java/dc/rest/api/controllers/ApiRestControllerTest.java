package dc.rest.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dc.rest.api.model.ApiServiceFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
        ApiServiceFactory apiServiceFactory = new ApiServiceFactory();
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiRestController(apiServiceFactory)).setControllerAdvice(new RestControllerAdvice()).build();
        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/services")).andReturn().getResponse();
        //then
        assertEquals(objectMapper.writeValueAsString(apiServiceFactory.factoryMethod()), response.getContentAsString());
    }

    @Test
    public void givenAGetRequestToServicesUriAndANullObject_whenGetServicesIsCalled_thenReturnErrorObject() throws Exception {
        //given
        ServiceNotFoundException e = new ServiceNotFoundException();
        String[] error = {e.getMessage(), HttpStatus.NOT_FOUND.toString()};
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiRestController(null)).setControllerAdvice(new RestControllerAdvice()).build();
        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/services")).andReturn().getResponse();
        //then
        assertEquals(objectMapper.writeValueAsString(error), response.getContentAsString());
    }
}

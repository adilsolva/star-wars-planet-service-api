package br.com.incubie.api;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class StarWarsPlanetControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	private static String PLANET_NAME = "Tatooine";
	
    @Test
    @Order(1)
    public void getPlanetList_FromDatabase_WhenNoData_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(get("/planets"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }
    
    @Test
    @Order(2)
    public void getPlanetByName_FromDatabase_WhenNoData_ThenReturnNotFound() throws Exception {
    	
        mockMvc.perform(get("/planets/name").param("name", PLANET_NAME))
        		.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No value present")));
    }
    
    @Test
    @Order(3)
    public void getPlanetById_FromDatabase_WhenNoData_ThenReturnNotFound() throws Exception {
    	
        mockMvc.perform(get("/planets/identifier").param("identifier", "1"))
        		.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No value present")));
    }
    
    @Test
    @Order(4)
    public void removePlanetById_FromDatabase_WhenNoData_ThenReturnNotFound() throws Exception {
    	
        mockMvc.perform(delete("/planets").param("identifier", "1"))
        		.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No value present")));
    }
    
    @Test
    @Order(4)
    public void addPlanet_WithInvalidName_ThenReturnNotFound() throws Exception {
    	
        mockMvc.perform(post("/planets")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{\"name\": \"abacaxi\",\"terrain\": \"no\",\"atmosphere\": \"yes\"}"))
        		.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No value present")));
    }
    
    @Test
    @Order(5)
    public void getPlanetList_FromSWAPI_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(get("/planets/integration").param("page", "1"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"name\":\"Tatooine\",\"diameter\":\"10465\",\"gravity\":\"1 standard\",\"population\":\"200000\",\"climate\":\"arid\",\"terrain\":\"desert\",\"films\":[\"https://swapi.dev/api/films/1/\",\"https://swapi.dev/api/films/3/\",\"https://swapi.dev/api/films/4/\",\"https://swapi.dev/api/films/5/\",\"https://swapi.dev/api/films/6/\"],\"created\":\"2014-12-09T13:50:49.641\"}")));
    }
    
    @Test
    @Order(6)
    public void addPlanet_WithValidName_ThenReturnSucess() throws Exception {
    	
        mockMvc.perform(post("/planets")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{\"name\": \"Tatooine\",\"terrain\": \"no\",\"atmosphere\": \"yes\"}"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"Tatooine\",\"terrain\":\"no\",\"atmosphere\":\"yes\",\"filmQty\":5}")));
    }
    
    @Test
    @Order(7)
    public void getPlanetList_FromDatabase_WhenContainingData_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(get("/planets"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"name\":\"Tatooine\",\"terrain\":\"no\",\"atmosphere\":\"yes\",\"filmQty\":5}]")));
    }
    
    @Test
    @Order(8)
    public void getPlanetByName_FromDatabase_WhenContainingData_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(get("/planets/name").param("name", PLANET_NAME))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"Tatooine\",\"terrain\":\"no\",\"atmosphere\":\"yes\",\"filmQty\":5}")));
    }
    
    @Test
    @Order(9)
    public void getPlanetById_FromDatabase_WhenContainingData_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(get("/planets/identifier").param("identifier", "1"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"Tatooine\",\"terrain\":\"no\",\"atmosphere\":\"yes\",\"filmQty\":5}")));
    }
    
    @Test
    @Order(10)
    public void removePlanetById_FromDatabase_WhenContainingData_ThenReturnSuccess() throws Exception {
    	
        mockMvc.perform(delete("/planets").param("identifier", "1"))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

}

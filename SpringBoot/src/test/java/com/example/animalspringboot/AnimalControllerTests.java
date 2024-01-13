package com.example.animalspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllAnimals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/zoo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAnimalById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/zoo/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAnimalByType() throws Exception {
        String type = "белка";
        mockMvc.perform(MockMvcRequestBuilders.get("/zoo/find")
                        .param("type", type)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAnimal() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/zoo")
                        .content("{ \"name\": \"имя\", \"type\": \"вид\", \"age\": \"возраст\", \"gender\": \"пол\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAnimal() throws Exception {

    }

    @Test
    public void testDeleteAnimal() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/zoo/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
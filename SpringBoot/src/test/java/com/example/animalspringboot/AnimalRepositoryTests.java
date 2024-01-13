package com.example.animalspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AnimalRepositoryTests {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    public void testFindByTypeIgnoreCase() {
        Animal animal = new Animal("Гоша", "медведь", "3", "М");
        animalRepository.save(animal);

        List<Animal> retrievedAnimals = animalRepository.findByTypeIgnoreCase("медведь");

        assertEquals(1, retrievedAnimals.size(), "Ожидание");
        assertEquals(animal.getType(), retrievedAnimals.get(0).getType());
    }
}
package com.example.animalspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AnimalServiceTests {

	@Autowired
	private AnimalService animalService;

	@MockBean
	private AnimalRepository animalRepository;

	@Test
	public void testGetAllAnimals() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("чики", "олень", "5", "М"));
		animals.add(new Animal("чака", "олень", "5", "Ж"));

		when(animalRepository.findAll()).thenReturn(animals);

		List<Animal> retrievedAnimals = animalService.getAllAnimals();
		assertEquals(2, retrievedAnimals.size(), "ожидание");
		System.out.println(retrievedAnimals);
	}

	@Test
	public void testGetAnimalById() {
		Long id = 1L;
		Animal animal = new Animal("FarCry 3", "Боевик", "2012", "700");
		animal.setId(id);

		when(animalRepository.findById(id)).thenReturn(Optional.of(animal));

		assertEquals(animal, animalService.getAnimalById(id).orElse(null));
	}

	@Test
	public void testAddAnimal() {
		Animal animal = new Animal("Гоша", "медведь", "3", "М");

		animalService.addAnimal(animal);

		verify(animalRepository, times(1)).save(animal);
	}

	@Test
	public void testUpdateAnimal() {
		Long id = 1L;
		Animal animal = new Animal("Изменено", "Изменено", "Изменено", "700");
		animal.setId(id);

		animalService.updateAnimal(animal);

		verify(animalRepository, times(1)).save(animal);
	}

	@Test
	public void testDeleteAnimal() {
		Long id = 1L;

		animalService.deleteAnimal(id);

		verify(animalRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindAnimalsByType() {
		String type = "медведь";
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Гоша", "медведь", "3", "М"));

		when(animalRepository.findByTypeIgnoreCase(type)).thenReturn(animals);

		assertEquals(1, animalService.findAnimalsByType(type).size());
	}
}

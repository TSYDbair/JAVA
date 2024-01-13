package com.example.animalspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {

        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {

        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {

        return animalService.getAnimalById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Animal> findAnimalByType(@RequestParam(name="type") String type) {
        return animalService.findAnimalsByType(type);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);
        animalService.updateAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(
            @PathVariable Long id) {
        animalService.deleteAnimal(id);
    }
}
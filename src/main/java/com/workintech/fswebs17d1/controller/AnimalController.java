package com.workintech.fswebs17d1.controller;



import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path= "/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullName;

    @GetMapping
    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    // İlgili id deki animal'ı döner
    @GetMapping("{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    // Yeni bir animal ekler
    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        System.out.println("add animal is triggered");
        this.animals.put(animal.getId(), animal);
    }

    // İlgili id deki animal'ı günceller
    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable("id") int id, @RequestBody Animal newAnimal) {
        this.animals.replace(id, newAnimal);
        return this.animals.get(id);
    }


    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable int id) {
        this.animals.remove(id);
    }
}

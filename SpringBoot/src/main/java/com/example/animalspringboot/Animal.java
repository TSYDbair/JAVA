package com.example.animalspringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String age;
    private String gender;
    public Animal() {
    }

    public Animal(String name, String type, String age, String genders) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.gender = genders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) &&
                Objects.equals(name, animal.name) &&
                Objects.equals(type, animal.type) &&
                Objects.equals(age, animal.age) &&
                Objects.equals(gender, animal.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, age, gender);
    }
}

package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PetShopStorage {

    private final DataStoringJob dataStoring;
    private List<Animal> animals = null;

    @Autowired
    public PetShopStorage(DataStoringJob dataStoringJob) {
        this.dataStoring = dataStoringJob;
    }

    public List<Animal> getAnimals() {
        if (animals == null) {
            animals = new ArrayList<Animal>();
            dataStoring.uploadAnimals(this);
        }
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Animal createNewAnimal() {
        switch ((new Random()).nextInt(4)) {
            case 0:
                return new Cat();
            case 1:
                return new Dog();
            case 2:
                return new Wolf();
            default:
                return new Shark();
        }
    }

    public Animal chooseRandomAnimal() {
        if (animals == null || animals.isEmpty()) {
            return null;
        }
        return animals.get((new Random()).nextInt(animals.size()));
    }
}

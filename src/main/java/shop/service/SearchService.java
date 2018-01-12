package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.Animal;
import shop.animals.AnimalBreed;
import shop.animals.AnimalCharacter;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final PetShopStorage storage;

    @Autowired
    public SearchService(PetShopStorage storage) {
        this.storage = storage;
    }

    public List<Animal> searchByName(String name) {
        List<Animal> allAnimals = storage.getAnimals();
        List<Animal> searchAnimals = new ArrayList<Animal>();
        for (Animal animal :
                allAnimals) {
            if (animal.getName().equals(name))
                searchAnimals.add(animal);
        }
        return searchAnimals;
    }

    public List<Animal> searchByBreed(AnimalBreed breed) {
        List<Animal> allAnimals = storage.getAnimals();
        List<Animal> searchAnimals = new ArrayList<Animal>();
        for (Animal animal :
                allAnimals) {
            if (animal.getBreed().equals(breed))
                searchAnimals.add(animal);
        }
        return searchAnimals;
    }

    public List<Animal> searchByCharacter(AnimalCharacter character) {
        List<Animal> allAnimals = storage.getAnimals();
        List<Animal> searchAnimals = new ArrayList<Animal>();
        for (Animal animal :
                allAnimals) {
            if (animal.getCharacter().equals(character))
                searchAnimals.add(animal);
        }
        return searchAnimals;
    }

    public List<Animal> searchByCost(int maxCost) {
        List<Animal> allAnimals = storage.getAnimals();
        List<Animal> searchAnimals = new ArrayList<Animal>();
        for (Animal animal :
                allAnimals) {
            if (animal.getCost() <= maxCost)
                searchAnimals.add(animal);
        }
        return searchAnimals;
    }
}

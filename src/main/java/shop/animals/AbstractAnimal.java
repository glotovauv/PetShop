package shop.animals;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class AbstractAnimal implements Animal {
    protected AnimalBreed breed;
    protected String name;
    protected Integer cost;
    protected AnimalCharacter character;
    protected Integer degreeOfPollution;

    AbstractAnimal() {
    }

    AbstractAnimal(String[] names, AnimalBreed[] breeds, AnimalCharacter[] characters, int minCost, int maxCost) {
        Random rand = new Random();
        breed = breeds[rand.nextInt(breeds.length)];
        character = characters[rand.nextInt(characters.length)];
        name = names[rand.nextInt(names.length)];
        cost = rand.nextInt(maxCost - minCost) + minCost;
        degreeOfPollution = 0;
    }

    public AnimalBreed getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public AnimalCharacter getCharacter() {
        return character;
    }

    public Integer getDegreeOfPollution() {
        return degreeOfPollution;
    }

    public void setDegreeOfPollution(Integer degreeOfPollution) {
        if (degreeOfPollution >= 0 && degreeOfPollution <= 100) {
            this.degreeOfPollution = degreeOfPollution;
        }
    }

    @Override
    public String toString() {
        return getName() + " - " + getBreed() + " - " + getCharacter() + " - "
                + getCost() + " руб. - " + getDegreeOfPollution() + "%";
    }

    public void setBreed(AnimalBreed breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setCharacter(AnimalCharacter character) {
        this.character = character;
    }


}

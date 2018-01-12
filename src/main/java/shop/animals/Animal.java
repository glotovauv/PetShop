package shop.animals;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public interface Animal {
    AnimalBreed getBreed();

    String getName();

    Integer getCost();

    AnimalCharacter getCharacter();

    Integer getDegreeOfPollution();

    void setDegreeOfPollution(Integer degreeOfPollution);
}

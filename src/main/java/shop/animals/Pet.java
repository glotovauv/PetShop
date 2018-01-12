package shop.animals;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Pet extends AbstractAnimal {
    private static final Integer MIN_COST = 100;
    private static final Integer MAX_COST = 1000;

    Pet() {
    }

    Pet(String[] names, AnimalBreed[] breeds) {
        super(names, breeds, PetCharacter.values(), MIN_COST, MAX_COST);
    }

    enum PetCharacter implements AnimalCharacter {
        CARESSING {
            @Override
            public String toString() {
                return "Ласковый";
            }
        },
        FRIENDLY {
            @Override
            public String toString() {
                return "Дружелюбный";
            }
        },
        FRISKY {
            @Override
            public String toString() {
                return "Игривый";
            }
        },
        SLEEPY {
            @Override
            public String toString() {
                return "Сонливый";
            }
        },
        JOYOUS {
            @Override
            public String toString() {
                return "Веселый";
            }
        }
    }
}

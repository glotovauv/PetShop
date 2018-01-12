package shop.animals;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class Predator extends AbstractAnimal {
    private static final Integer MIN_COST = 1000;
    private static final Integer MAX_COST = 10000;

    Predator() {
    }

    Predator(String[] names, AnimalBreed[] breeds) {
        super(names, breeds, PredatorCharacter.values(), MIN_COST, MAX_COST);
    }

    enum PredatorCharacter implements AnimalCharacter {
        AGGRESSIVE {
            @Override
            public String toString() {
                return "Агрессивный";
            }
        },
        WARY {
            @Override
            public String toString() {
                return "Осторожный";
            }
        },
        DARING {
            @Override
            public String toString() {
                return "Смелый";
            }
        },
        QUIET {
            @Override
            public String toString() {
                return "Тихий";
            }
        },
        PROMPT {
            @Override
            public String toString() {
                return "Быстрый";
            }
        }
    }
}

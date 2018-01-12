package shop.animals;

public class Dog extends Pet {
    public Dog() {
        super(dogNames, DogBreed.values());
    }

    private static String[] dogNames = {
            "Шарик", "Мухтар", "Джим", "Барон", "Рекс"
    };

    public Dog(String name, AnimalBreed breed, Integer cost, AnimalCharacter character, Integer degreeOfPollution) {
        setName(name);
        setBreed(breed);
        setCost(cost);
        setCharacter(character);
        setDegreeOfPollution(degreeOfPollution);
    }

    enum DogBreed implements AnimalBreed {
        GERMAN_SHEPHERD {
            @Override
            public String toString() {
                return "Немецкая овчарка";
            }
        },
        DACHSHUND {
            @Override
            public String toString() {
                return "Такса";
            }
        },
        LABRADOR {
            @Override
            public String toString() {
                return "Лабрадор";
            }
        },
        ST_BERNARD {
            @Override
            public String toString() {
                return "Сенбернар";
            }
        },
        NEWFOUNDLAND {
            @Override
            public String toString() {
                return "Ньюфаундленд";
            }
        }
    }
}

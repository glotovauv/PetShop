package shop.animals;

public class Wolf extends Predator implements AnimalBreed {
    public Wolf() {
        super(wolfNames, WolfBreed.values());
    }

    private static String[] wolfNames = {
            "Серый", "Гром", "Норд", "Дик", "Зевс"
    };

    public Wolf(String name, AnimalBreed breed, Integer cost, AnimalCharacter character, Integer degreeOfPollution) {
        setName(name);
        setBreed(breed);
        setCost(cost);
        setCharacter(character);
        setDegreeOfPollution(degreeOfPollution);
    }

    enum WolfBreed implements AnimalBreed {
        ARCTIC_WOLF {
            @Override
            public String toString() {
                return "Полярный волк";
            }
        },
        RED_WOLF {
            @Override
            public String toString() {
                return "Красный волк";
            }
        },
        SIBERIAN_WOLF {
            @Override
            public String toString() {
                return "Сибирский волк";
            }
        },
        PRAIRIE_WOLF {
            @Override
            public String toString() {
                return "Степной волк";
            }
        },
        CAUCASIAN_WOLF {
            @Override
            public String toString() {
                return "Кавказский волк";
            }
        }
    }
}

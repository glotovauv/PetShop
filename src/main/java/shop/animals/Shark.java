package shop.animals;

public class Shark extends Predator {
    public Shark() {
        super(sharkNames, SharkBreed.values());
    }

    private static String[] sharkNames = {
            "Дори", "Блеск", "Сильвер", "Турбо", "Скали"
    };

    public Shark(String name, AnimalBreed breed, Integer cost, AnimalCharacter character, Integer degreeOfPollution) {
        setName(name);
        setBreed(breed);
        setCost(cost);
        setCharacter(character);
        setDegreeOfPollution(degreeOfPollution);
    }

    enum SharkBreed implements AnimalBreed {
        GREAT_HAMMERHEAD {
            @Override
            public String toString() {
                return "Гигантская акула-молот";
            }
        },
        TIGER_SHARK {
            @Override
            public String toString() {
                return "Тигровая акула";
            }
        },
        SILKY_SHARK {
            @Override
            public String toString() {
                return "Шелковая акула";
            }
        },
        BULL_SHARK {
            @Override
            public String toString() {
                return "Акула-бык";
            }
        },
        SANDBAR_SHARK {
            @Override
            public String toString() {
                return "Песчаная акула";
            }
        }
    }
}


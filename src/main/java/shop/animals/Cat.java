package shop.animals;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Cat extends Pet {
    public List<ShowCats> getListShowCats() {
        return listShowCats;
    }

    public Cat() {
        super(catNames, CatBreed.values());
        listShowCats = new ArrayList<ShowCats>();
        Random rand = new Random();
        int countExhibition = rand.nextInt(3);
        for (int i = 0; i < countExhibition; i++) {
            listShowCats.add(new ShowCats(rand));
        }
    }

    public Cat(String name, AnimalBreed breed, Integer cost, AnimalCharacter character, Integer degreeOfPollution, List<ShowCats> listShowCats) {
        setName(name);
        setBreed(breed);
        setCost(cost);
        setCharacter(character);
        setDegreeOfPollution(degreeOfPollution);
        this.listShowCats = listShowCats;
    }

    private static String[] catNames = {
            "Барсик", "Мурзик", "Тима", "Васька", "Граф"
    };

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    private static class ShowCats {
        private Date date;
        private Integer numberPlace;
        private String town;

        ShowCats(Random rand) {
            numberPlace = rand.nextInt(4) + 1;
            date = new Date(Math.abs(System.currentTimeMillis() - rand.nextLong()));
            town = nameTowns[rand.nextInt(nameTowns.length)];
        }

        ShowCats() {
        }

        public ShowCats(Date date, Integer numberPlace, String town) {
            this.date = date;
            this.numberPlace = numberPlace;
            this.town = town;
        }

        private String[] nameTowns = {"Москва", "Волгоград", "Самара", "Курск", "Воронеж"};

        public Date getDate() {
            return date;
        }

        public Integer getNumberPlace() {
            return numberPlace;
        }

        public String getTown() {
            return town;
        }
    }

    private List<ShowCats> listShowCats;

    enum CatBreed implements AnimalBreed {
        PERSIAN_CAT {
            @Override
            public String toString() {
                return "Персидская кошка";
            }
        },
        SIAMESE_CAT {
            @Override
            public String toString() {
                return "Сиамская кошка";
            }
        },
        MAINE_COON {
            @Override
            public String toString() {
                return "Мейн кун";
            }
        },
        BRITISH_CAT {
            @Override
            public String toString() {
                return "Британец";
            }
        },
        ANGORA_CAT {
            @Override
            public String toString() {
                return "Ангорская кошка";
            }
        }
    }

    @Override
    public String toString() {
        String result = super.toString();
        if (listShowCats.size() > 0) result += " - ";
        for (ShowCats show : listShowCats) {
            result += show.getTown() + ", " + show.getNumberPlace() + " место; ";
        }
        return result;
    }
}

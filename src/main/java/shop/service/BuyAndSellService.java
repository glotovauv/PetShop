package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.Animal;

@Service
public class BuyAndSellService {

    private final PetShopStorage storage;
    private final PrintingService print;

    @Autowired
    public BuyAndSellService(PetShopStorage petShopStorage, PrintingService printingService) {
        this.storage = petShopStorage;
        this.print = printingService;
    }

    public void buy(Animal animal) {
        storage.getAnimals().add(animal);
        print.printBuyOperation(animal);
    }

    public void sell(Animal animal) {
        storage.getAnimals().remove(animal);
        print.printSellOperation(animal);
    }
}

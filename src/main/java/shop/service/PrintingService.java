package shop.service;

import org.springframework.stereotype.Service;
import shop.animals.Animal;

@Service
public class PrintingService {

    public void printBuyOperation(Animal animal) {
        System.out.println("Куплено животное: " + animal);
    }

    public void printSellOperation(Animal animal) {
        System.out.println("Продано животное: " + animal);
    }

    public void printRunAwayAnimal(Animal animal) {
        System.out.println("Побег животного: " + animal);
    }

    public void printEmptyStorage() {
        System.out.println("Хранилище пусто!");
    }
}

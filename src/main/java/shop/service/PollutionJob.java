package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.Animal;

import java.util.Random;

@Service
public class PollutionJob implements Runnable {
    private final PetShopStorage storage;

    @Autowired
    public PollutionJob(PetShopStorage petShopStorage) {
        this.storage = petShopStorage;
    }

    public void run() {
        Random rand = new Random();
        while (true) {
            synchronized (storage) {
                for (Animal animal :
                        storage.getAnimals()) {
                    int difference = rand.nextInt(11) + 20, oldValuePollution = animal.getDegreeOfPollution();
                    int newValuePollution = oldValuePollution + difference >= 100 ? 100 : oldValuePollution + difference;
                    animal.setDegreeOfPollution(newValuePollution);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

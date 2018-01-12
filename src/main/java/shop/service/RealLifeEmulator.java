package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.Animal;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
public class RealLifeEmulator {

    private final PetShopStorage storage;
    private final BuyAndSellService buyAndSell;
    private final PrintingService print;
    private final DataStoringJob storingJob;
    private final PollutionJob pollutionJob;
    private final CleaningJob cleaningJob;

    @Autowired
    public RealLifeEmulator(PetShopStorage storage, BuyAndSellService buyAndSellService, PrintingService printingService,
                            DataStoringJob dataStoringJob, PollutionJob pollutionJob, CleaningJob cleaningJob) {
        this.storage = storage;
        this.buyAndSell = buyAndSellService;
        this.print = printingService;
        this.storingJob = dataStoringJob;
        this.pollutionJob = pollutionJob;
        this.cleaningJob = cleaningJob;
    }

    private void startDaemonThread(Thread thread) {
        thread.setDaemon(true);
        thread.start();
    }

    private Thread createSaveAnimalsThread() {
        return new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (storage) {
                    storingJob.saveAnimals(storage);
                }
            }
        });
    }

    private void runAway(Animal animal) {
        storage.getAnimals().remove(animal);
        print.printRunAwayAnimal(animal);
    }

    @PostConstruct
    public void start() {
        startDaemonThread(createSaveAnimalsThread());
        startDaemonThread(new Thread(cleaningJob));
        startDaemonThread(new Thread(pollutionJob));
        while (true) {
            switch ((new Random()).nextInt(10)) {
                case 1:
                case 2:
                case 3:
                case 4:
                    buyAndSell.buy(storage.createNewAnimal());
                    break;
                case 5:
                case 6:
                    if (!storage.getAnimals().isEmpty()) {
                        buyAndSell.sell(storage.chooseRandomAnimal());
                    } else print.printEmptyStorage();
                    break;
                case 7:
                    if (!storage.getAnimals().isEmpty()) {
                        runAway(storage.chooseRandomAnimal());
                    } else print.printEmptyStorage();
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public PetShopStorage getStorage() {
        return storage;
    }

    public BuyAndSellService getBuyAndSell() {
        return buyAndSell;
    }
}

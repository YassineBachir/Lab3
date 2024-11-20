package dam.uam.sbonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dam.uam.sbonline.domain.Car;
import dam.uam.sbonline.domain.CarRepository;
import dam.uam.sbonline.domain.Owner;
import dam.uam.sbonline.domain.OwnerRepository;

import java.util.Arrays;

@SpringBootApplication
public class SbOnlineShop implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SbOnlineShop.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SbOnlineShop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Création des propriétaires
        Owner owner1 = new Owner("Ndeye", "Fall");
        Owner owner2 = new Owner("Sokhna", "Traore");
        Owner owner3 = new Owner("Demba", "Ndiaye");

        // Sauvegarde des propriétaires
        ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));

        // Création des voitures
        Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
        Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner3);

        // Sauvegarde des voitures
        carRepository.saveAll(Arrays.asList(car1, car2, car3));

        // Log des voitures sauvegardées
        carRepository.findAll().forEach(car -> 
            logger.info(car.getBrand() + " " + car.getModel())
        );
    }
}

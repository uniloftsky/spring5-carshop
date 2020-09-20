package uniloft.springframework.spring5carshop.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uniloft.springframework.spring5carshop.model.TestCar;
import uniloft.springframework.spring5carshop.services.CarRepository;
import uniloft.springframework.spring5carshop.services.CarTypeRepository;
import uniloft.springframework.spring5carshop.services.EngineRepository;
import uniloft.springframework.spring5carshop.services.TestCarRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final CarTypeRepository carTypeRepository;
    private final EngineRepository engineRepository;
    private final TestCarRepository testCarRepository;

    public DataLoader(CarRepository carRepository, CarTypeRepository carTypeRepository, EngineRepository engineRepository, TestCarRepository testCarRepository, TestCarRepository testCarRepository1) {
        this.carRepository = carRepository;
        this.carTypeRepository = carTypeRepository;
        this.engineRepository = engineRepository;
        this.testCarRepository = testCarRepository1;
    }

    @Override
    public void run(String... args) throws Exception {

        TestCar testcar1 = new TestCar();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate ld1 = LocalDate.now();
        ld1.format(formatter);
        System.out.println(ld1);
        /*testcar1.setDate(LocalDate.now());
        testcar1.setCount(1);
        testCarRepository.save(testcar1);*/

    }
}

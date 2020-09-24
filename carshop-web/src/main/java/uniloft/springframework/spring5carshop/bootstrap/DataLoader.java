package uniloft.springframework.spring5carshop.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;
import uniloft.springframework.spring5carshop.services.repositories.CarTypeRepository;
import uniloft.springframework.spring5carshop.services.repositories.EngineRepository;
import uniloft.springframework.spring5carshop.services.repositories.TestCarRepository;

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

    }
}

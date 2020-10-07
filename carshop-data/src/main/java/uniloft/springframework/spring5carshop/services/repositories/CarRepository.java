package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Car;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findCarByBrandNameAndModelNameAndBodyNameAndEngine_Type(String brandName, String modelName, String bodyName, String engineType);

}

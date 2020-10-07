package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.enums.EngineType;

import java.util.Optional;
import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findCarByBrandNameAndModelNameAndBodyNameAndEngine_Type(String brandName, String modelName, String bodyName, EngineType engineType);
    Set<Car> findCarsByCarType_Id(Long carTypeId);

}

package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.TestCar;

public interface TestCarRepository extends CrudRepository<TestCar, Long> {
}

package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.CarBody;

public interface CarBodyRepository extends CrudRepository<CarBody, Long> {
}

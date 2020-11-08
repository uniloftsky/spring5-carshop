package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.CarModel;

public interface CarModelRepository extends CrudRepository<CarModel, Long> {

}

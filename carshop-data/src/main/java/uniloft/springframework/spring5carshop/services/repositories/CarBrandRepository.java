package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.CarBrand;

public interface CarBrandRepository extends CrudRepository<CarBrand, Long> {
}

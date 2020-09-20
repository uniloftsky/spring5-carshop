package uniloft.springframework.spring5carshop.services;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.CarType;

import java.util.Optional;

public interface CarTypeRepository extends CrudRepository<CarType, Long> {

    Optional<CarType> findByTypeName(String typeName);

}

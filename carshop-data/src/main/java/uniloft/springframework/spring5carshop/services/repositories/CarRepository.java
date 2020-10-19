package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Car;

import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {

    Set<Car> findCarsByCarType_Id(Long carTypeId);
    Page<Car> findAll(Pageable pageable);

}

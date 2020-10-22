package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Car;

import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {

    Set<Car> findCarsByCarType_Id(Long carTypeId);
    Page<Car> findAll(Pageable pageable);
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(String brandName, String modelName, String bodyName, Pageable pageable);
    Page<Car> findCarsByModel_ModelNameAndBody_BodyName(String modelName, String bodyName, Pageable pageable);
    Page<Car> findCarsByBrand_BrandName(String brandName, Pageable pageable);
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelName(String brandName, String modelName, Pageable pageable);
    Page<Car> findCarsByModel_ModelName(String modelName, Pageable pageable);
    Page<Car> findCarsByBody_BodyName(String bodyName, Pageable pageable);
    Page<Car> findCarsByBrand_BrandNameAndBody_BodyName(String brandName, String bodyName, Pageable pageable);
}

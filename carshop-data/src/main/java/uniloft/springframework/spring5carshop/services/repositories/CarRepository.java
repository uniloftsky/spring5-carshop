package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uniloft.springframework.spring5carshop.model.Car;

import java.util.List;
import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {

    Set<Car> findCarsByCarType_Id(Long carTypeId);
    Page<Car> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id WHERE CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND CAR_BRAND.brand_name IN (:brandName)")
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id WHERE CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName)")
    Page<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, Pageable pageable);

    @Query(value = "SELECT car From Car car WHERE car.brand.brandName IN :brandName")
    Page<Car> findCarsByBrand_BrandName(@Param("brandName") List<String> brandName, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id WHERE CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName)")
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, Pageable pageable);

    @Query(value = "SELECT car From Car car WHERE car.model.modelName IN :modelName")
    Page<Car> findCarsByModel_ModelName(List<String> modelName, Pageable pageable);

    @Query(value = "SELECT car From Car car WHERE car.body.bodyName IN :bodyName")
    Page<Car> findCarsByBody_BodyName(List<String> bodyName, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id WHERE CAR_BRAND.brand_name IN (:brandName) AND CAR_BODY.body_name IN (:bodyName)")
    Page<Car> findCarsByBrand_BrandNameAndBody_BodyName(@Param("brandName") List<String> brandName, @Param("bodyName") List<String> bodyName, Pageable pageable);

}

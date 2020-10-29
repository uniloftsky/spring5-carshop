package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uniloft.springframework.spring5carshop.model.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {

    Set<Car> findCarsByCarType_Id(Long carTypeId);

    Set<Car> findAll();

    @Query(value = "SELECT car From Car car WHERE car.price <= :maxPrice AND car.price >= :minPrice")
    Set<Car> findCars(BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id WHERE CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND CAR_BRAND.brand_name IN (:brandName) AND CAR.price <= :maxPrice AND CAR.price >= :minPrice")
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id WHERE CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND CAR.price <= :maxPrice AND CAR.price >= :minPrice")
    Set<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(value = "SELECT car From Car car WHERE car.brand.brandName IN :brandName AND car.price <= :maxPrice AND car.price >= :minPrice")
    Set<Car> findCarsByBrand_BrandName(List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id WHERE CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND CAR.price <= :maxPrice AND CAR.price >= :minPrice")
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(value = "SELECT car From Car car WHERE car.model.modelName IN :modelName AND car.price <= :maxPrice AND car.price >= :minPrice")
    Set<Car> findCarsByModel_ModelName(List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(value = "SELECT car From Car car WHERE car.body.bodyName IN :bodyName AND car.price <= :maxPrice AND car.price >= :minPrice")
    Set<Car> findCarsByBody_BodyName(List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM CAR INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id WHERE CAR_BRAND.brand_name IN (:brandName) AND CAR_BODY.body_name IN (:bodyName) AND CAR.price <= :maxPrice AND CAR.price >= :minPrice")
    Set<Car> findCarsByBrand_BrandNameAndBody_BodyName(@Param("brandName") List<String> brandName, @Param("bodyName") List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id WHERE ENGINE.type IN (:engineType) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_Description(List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id WHERE ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandName(List<String> engineType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id WHERE ENGINE.type IN (:engineType) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelName(List<String> engineType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE ENGINE.type IN (:engineType) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndBody_BodyName(List<String> engineType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id WHERE ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyName(List<String> engineType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE ENGINE.type IN (:engineType) AND CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelNameAndBody_BodyName(List<String> engineType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id WHERE CAR_TYPE.type_name IN (:carType) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeName(List<String> carType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = CAR.engine_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndEngine_Type_Description(List<String> carType, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_BRAND.brand_name IN (:brandName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandName(List<String> carType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelName(List<String> carType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_BODY ON CAR_BODY.id = CAR.body_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBody_BodyName(List<String> carType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelName(List<String> carType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = CAR.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_MODEl.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = CAR.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BODY.body_name IN (:bodyName) AND CAR_MODEL.model_name IN (:modelName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

    @Query(nativeQuery = true, value="SELECT * FROM Car INNER JOIN CAR_TYPE ON CAR_TYPE.id = CAR.type_type_id INNER JOIN ENGINE ON ENGINE.id = Car.engine_id INNER JOIN CAR_BRAND ON CAR_BRAND.id = Car.brand_id INNER JOIN CAR_MODEL ON CAR_MODEL.id = Car.model_id INNER JOIN CAR_BODY ON CAR_BODY.id = Car.body_id WHERE CAR_TYPE.type_name IN (:carType) AND ENGINE.type IN (:engineType) AND CAR_BRAND.brand_name IN (:brandName) AND CAR_MODEL.model_name IN (:modelName) AND CAR_BODY.body_name IN (:bodyName) AND Car.price BETWEEN :minPrice AND :maxPrice")
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
}
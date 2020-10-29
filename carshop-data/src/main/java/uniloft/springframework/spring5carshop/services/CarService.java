package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Car;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface CarService {

    Set<Car> getCars();
    TreeSet<Car> getSortedCars(Comparator<Car> comparator);
    Car findById(Long id);
    Long getCarsCount();
    Set<Car> findAll();
    Set<Car> findCars(BigDecimal minPrice, BigDecimal maxPrice);
    BigDecimal findMinPrice();
    BigDecimal findMaxPrice();
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandName(List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByModel_ModelName(List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBody_BodyName(List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandNameAndBody_BodyName(List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_Description(List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandName(List<String> engineType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelName(List<String> engineType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndBody_BodyName(List<String> engineType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyName(List<String> engineType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelNameAndBody_BodyName(List<String> engineType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeName(List<String> carType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndEngine_Type_Description(List<String> carType, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandName(List<String> carType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelName(List<String> carType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBody_BodyName(List<String> carType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelName(List<String> carType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice);

}

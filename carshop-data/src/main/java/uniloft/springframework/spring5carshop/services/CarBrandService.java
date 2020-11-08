package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;

import java.util.Set;

public interface CarBrandService {

    CarBrand findCarBrandById(Long id);
    CarModel findCarModelById(Long id);
    void deleteBrand(CarBrand carBrand);
    Set<CarBrand> getCarBrands();
    Set<CarModel> getBrandModels();
    Set<CarBody> getModelBodies();
    CarBrand saveBrand(CarBrand carBrand);
    CarModel saveModel(CarModel carModel);

}

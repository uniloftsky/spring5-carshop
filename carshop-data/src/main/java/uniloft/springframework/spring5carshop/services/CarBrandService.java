package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;

import java.util.Set;

public interface CarBrandService {

    Set<CarBrand> getBrands();
    Set<CarModel> getBrandModels();
    Set<CarBody> getModelBodies();

}
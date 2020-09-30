package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.CarType;

import java.util.Set;

public interface CarTypeService {

    Set<CarType> getCarTypes();
    CarType saveOrUpdate(CarType carType);
    CarType findById(Long id);

}

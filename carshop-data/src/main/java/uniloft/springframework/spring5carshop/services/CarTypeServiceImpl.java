package uniloft.springframework.spring5carshop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.CarType;
import uniloft.springframework.spring5carshop.services.repositories.CarTypeRepository;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class CarTypeServiceImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    @Override
    public Set<CarType> getCarTypes() {
        Set<CarType> types = new HashSet<>();
        carTypeRepository.findAll().forEach(types::add);
        return types;
    }
}

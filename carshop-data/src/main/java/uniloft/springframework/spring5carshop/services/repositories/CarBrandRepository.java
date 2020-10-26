package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.CarBrand;

import java.util.Set;

public interface CarBrandRepository extends CrudRepository<CarBrand, Long> {

    @Query(value = "SELECT carBrand FROM CarBrand carBrand ORDER BY carBrand.brandName ASC")
    Set<CarBrand> getCarBrands();

}

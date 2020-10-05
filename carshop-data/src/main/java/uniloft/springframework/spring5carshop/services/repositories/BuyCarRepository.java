package uniloft.springframework.spring5carshop.services.repositories;


import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.BuyCar;

public interface BuyCarRepository extends CrudRepository<BuyCar, Long> {
}

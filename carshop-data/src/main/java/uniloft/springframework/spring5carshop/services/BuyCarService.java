package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.BuyCar;

import java.util.Set;

public interface BuyCarService {

    Set<BuyCar> getBuyCars();
    BuyCar save(BuyCar buyCar);
    BuyCar findById(Long id);
    void delete(BuyCar buyCar);

}

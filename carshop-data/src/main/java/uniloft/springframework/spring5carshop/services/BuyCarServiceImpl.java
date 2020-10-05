package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.BuyCar;
import uniloft.springframework.spring5carshop.services.repositories.BuyCarRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BuyCarServiceImpl implements BuyCarService {

    private final BuyCarRepository buyCarRepository;

    public BuyCarServiceImpl(BuyCarRepository buyCarRepository) {
        this.buyCarRepository = buyCarRepository;
    }

    @Override
    public Set<BuyCar> getBuyCars() {
        Set<BuyCar> buyCars = new HashSet<>();
        buyCarRepository.findAll().iterator().forEachRemaining(buyCars::add);
        return buyCars;
    }

    @Override
    public BuyCar save(BuyCar buyCar) {
        return buyCarRepository.save(buyCar);
    }

    @Override
    public BuyCar findById(Long id) {
        Optional<BuyCar> buyCarOptional = buyCarRepository.findById(id);
        if(buyCarOptional.isEmpty()) {
            throw new RuntimeException("Expected buycar not found!");
        }
        return buyCarOptional.get();
    }

    @Override
    public void delete(BuyCar buyCar) {
        buyCarRepository.delete(buyCar);
    }
}

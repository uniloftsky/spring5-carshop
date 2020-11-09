package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.Engine;
import uniloft.springframework.spring5carshop.services.repositories.EngineRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;

    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public Set<Engine> getEngines() {
        Set<Engine> engines = new HashSet<>();
        engineRepository.findAll().iterator().forEachRemaining(engines::add);
        return engines;
    }

    @Override
    public Engine findById(Long id) {
        Optional<Engine> engineOptional = engineRepository.findById(id);
        if(engineOptional.isEmpty()) {
            throw new NotFoundException("Двигун з ID: " + id + " не знайдено!");
        }
        return engineOptional.get();
    }

    @Override
    public Engine save(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public void delete(Engine engine) {
        engineRepository.delete(engine);
    }
}

package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Engine;

import java.util.Set;

public interface EngineService {

    Set<Engine> getEngines();
    Engine findById(Long id);
    Engine save(Engine engine);
    void delete(Engine engine);

}

package uniloft.springframework.spring5carshop.services;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Engine;

public interface EngineRepository extends CrudRepository<Engine, Long> {
}

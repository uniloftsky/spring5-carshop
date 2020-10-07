package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Color;

public interface ColorRepository extends CrudRepository<Color, Long> {
}

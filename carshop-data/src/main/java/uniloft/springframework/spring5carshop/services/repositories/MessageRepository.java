package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}

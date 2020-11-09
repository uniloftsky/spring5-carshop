package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Message;

import java.util.Set;

public interface MessageService {

    Message findById(Long id);
    Message save(Message message, String name, String email, String phone, String comment);
    void delete(Message message);
    Set<Message> findAll();

}

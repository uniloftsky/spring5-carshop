package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.Message;
import uniloft.springframework.spring5carshop.services.repositories.MessageRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message findById(Long id) {
        Optional<Message> messageOptional = messageRepository.findById(id);
        if(messageOptional.isEmpty()) {
            throw new NotFoundException("Повідомлення з ID: " + id + " не знайдено!");
        }

        return messageOptional.get();
    }

    @Override
    public Message save(Message message, String name, String email, String phone, String comment) {
        message.setName(name);
        message.setEmail(email);
        message.setPhone(phone);
        message.setComment(comment);
        return messageRepository.save(message);
    }

    @Override
    public void delete(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public Set<Message> findAll() {
        Set<Message> messages = new HashSet<>();
        messageRepository.findAll().iterator().forEachRemaining(messages::add);
        return messages;
    }
}

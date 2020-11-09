package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.Color;
import uniloft.springframework.spring5carshop.services.repositories.ColorRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Color findById(Long id) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        if(colorOptional.isEmpty()) {
            throw new NotFoundException("Колір з ID: " + id + " не знайдено!");
        }
        return colorOptional.get();
    }

    @Override
    public Set<Color> getColors() {
        Set<Color> colors = new HashSet<>();
        colorRepository.findAll().iterator().forEachRemaining(colors::add);
        return colors;
    }

    @Override
    public Color save(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void delete(Color color) {
        colorRepository.delete(color);
    }
}

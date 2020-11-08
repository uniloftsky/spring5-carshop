package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Color;

import java.util.Set;

public interface ColorService {

    Color findById(Long id);
    Set<Color> getColors();
    Color save(Color color);
    void delete(Color color);

}

package uniloft.springframework.spring5carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uniloft.springframework.spring5carshop.model.enums.EngineConfig;
import uniloft.springframework.spring5carshop.model.enums.EngineType;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Engine extends BaseEntity {

    private String name;

    @Enumerated(value = EnumType.STRING)
    @Convert(converter = EngineType.class)
    private EngineType type;

    private int capacity;
    private int power;

    @Enumerated(value = EnumType.STRING)
    @Convert(converter = EngineConfig.class)
    private EngineConfig config;

    private int cylinders;
}

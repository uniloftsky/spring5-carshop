package uniloft.springframework.spring5carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uniloft.springframework.spring5carshop.model.enums.EngineConfig;
import uniloft.springframework.spring5carshop.model.enums.EngineType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Engine extends BaseEntity {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private EngineType type;

    @NotNull
    private int capacity;

    @NotNull
    private int power;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private EngineConfig config;

    private int cylinders;
}

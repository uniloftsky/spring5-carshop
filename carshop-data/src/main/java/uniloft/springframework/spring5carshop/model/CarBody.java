package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class CarBody extends BaseEntity {

    @NotBlank(message = "{bodyName.NotBlank}")
    @Size(min = 1, max = 100, message = "{bodyName.Size}")
    private String bodyName;

    @NotNull
    @ManyToOne
    private CarModel model;

}

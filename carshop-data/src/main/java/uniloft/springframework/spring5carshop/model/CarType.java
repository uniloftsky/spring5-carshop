package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class CarType extends BaseEntity {

    @NotBlank(message = "{typeName.NotBlank}")
    @Size(min = 1, max = 50, message = "{typeName.Size}")
    private String typeName;
}

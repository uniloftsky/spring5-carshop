package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Color extends BaseEntity {

    @NotBlank(message = "{colorName.NotBlank}")
    @Size(min = 2, max = 50, message = "{colorName.Size}")
    private String colorName;

}

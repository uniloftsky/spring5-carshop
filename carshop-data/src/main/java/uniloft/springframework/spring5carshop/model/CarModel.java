package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CarModel extends BaseEntity {

    @NotBlank
    @Size(min = 1, max = 100)
    private String modelName;

    @NotNull
    @ManyToOne
    private CarBrand brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private Set<CarBody> carBodySet = new HashSet<>();

}

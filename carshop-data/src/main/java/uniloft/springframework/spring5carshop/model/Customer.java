package uniloft.springframework.spring5carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    @NotBlank(message = "{firstName.NotBlank}")
    @Size(min = 2, max = 255, message = "{firstName.Size}")
    private String firstName;

    @NotBlank(message = "{lastName.NotBlank}")
    @Size(min = 2, max = 255, message = "{lastName.Size}")
    private String lastName;

    @NotBlank(message = "{address.NotBlank}")
    @Size(min = 5, max = 100, message = "{address.Size}")
    private String address;

    @NotBlank(message = "{telephone.NotBlank}")
    @Size(min = 5, max = 15, message = "{telephone.Size}")
    private String telephone;

    @OneToMany(mappedBy = "customer")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<TestCar> testCars = new HashSet<>();
}

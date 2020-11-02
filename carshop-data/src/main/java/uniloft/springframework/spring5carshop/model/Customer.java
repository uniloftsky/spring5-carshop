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

    @NotBlank
    @Size(min = 5, max = 255)
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 255)
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 255)
    private String address;

    @NotBlank
    @Size(min = 5, max = 20)
    private String telephone;

    @OneToMany(mappedBy = "customer")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<TestCar> testCars = new HashSet<>();
}

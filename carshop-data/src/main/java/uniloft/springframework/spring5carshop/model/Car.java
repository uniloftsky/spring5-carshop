package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Car extends BaseEntity {

    @NotNull
    @ManyToOne
    private Engine engine;

    @NotNull
    @ManyToOne
    private CarType carType;

    @OneToMany(mappedBy = "car")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "car")
    private Set<TestCar> testCars = new HashSet<>();

    @NotNull(message = "{car.brand.NotNull}")
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @NotNull(message = "{car.model.NotNull}")
    @ManyToOne
    @JoinColumn(name = "model_id")
    private CarModel model;

    @NotNull(message = "{car.body.NotNull}")
    @ManyToOne
    @JoinColumn(name = "body_id")
    private CarBody body;

    @NotNull(message = "{car.price.NotNull}")
    @Min(0)
    private BigDecimal price;

    @NotNull(message = "{car.testPrice.NotNull}")
    @Min(0)
    private BigDecimal testPrice;

    @NotNull(message = "{car.color.NotNull}")
    @ManyToOne
    private Color color;

    @Lob
    private String image;

    @NotBlank(message = "{car.description.NotBlank}")
    @Size(min = 10, max = 1000, message = "{car.description.Size}")
    @Lob
    private String description;

    @NotBlank(message = "{car.subDescription.NotBlank}")
    @Size(min = 10, max = 100, message = "{car.subDescription.Size}")
    @Lob
    private String subDescription;
}

package uniloft.springframework.spring5carshop.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String telephone;

    @OneToMany(mappedBy = "customer")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<TestCar> testCars = new HashSet<>();

    public Customer() {}

    public Customer(String firstName, String lastName, String address, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

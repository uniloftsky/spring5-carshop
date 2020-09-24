package uniloft.springframework.spring5carshop.model;

import javax.persistence.Entity;

@Entity
public class CarType extends BaseEntity {

    private String typeName;
    private String add;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

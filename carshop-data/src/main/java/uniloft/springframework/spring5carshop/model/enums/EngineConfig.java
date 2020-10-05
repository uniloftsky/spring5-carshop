package uniloft.springframework.spring5carshop.model.enums;

public enum EngineConfig {

    VEE("V-подібний"),
    INLINE("Рядний"),
    ROTOR("Роторний");

    private final String description;

    EngineConfig(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

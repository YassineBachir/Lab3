package dam.uam.sbonline.domain;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    // Constructeur par défaut
    public Owner() {}

    // Constructeur avec paramètres
    public Owner(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters et setters
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

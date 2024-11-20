package dam.uam.sbonline.domain;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;
    private String color;
    private String registerNumber;

    @Column(name = "annee")
    private int year;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id") // Renommage pour correspondre aux conventions SQL
    private Owner owner;

    // Constructeur par défaut
    public Car() {}

    // Constructeur avec paramètres
    public Car(String brand, String model, String color, String registerNumber, int year, double price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public Owner getOwner() {
        return owner;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

package ru.job4j.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Column(name = "car_year")
    private int year;
    private int kilometer;
    private byte[] photo;
    @ManyToOne
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "BRAND_ID_FK"), nullable = false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"), nullable = false)
    private Engine engine;
    @ManyToOne
    @JoinColumn(name = "body_id", foreignKey = @ForeignKey(name = "BODY_ID_FK"), nullable = false)
    private Engine body;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)})
    Set<Driver> drivers = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getBody() {
        return body;
    }

    public void setBody(Engine body) {
        this.body = body;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id
                && Objects.equals(brand, car.brand)
                && Objects.equals(engine, car.engine)
                && Objects.equals(body, car.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, engine, body);
    }
}

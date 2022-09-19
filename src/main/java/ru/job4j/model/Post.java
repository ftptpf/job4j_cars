package ru.job4j.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime created;
    private boolean sold;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setUser(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(created, post.created)
                && Objects.equals(driver, post.driver)
                && Objects.equals(car, post.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, driver, car);
    }
}

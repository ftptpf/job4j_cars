package ru.job4j.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private LocalDateTime created;
    private long price;
    private boolean sale;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceHistory> priceHistory = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "participates",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false)}
    )
    private List<User> participates = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sold) {
        this.sale = sold;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<PriceHistory> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public List<User> getParticipates() {
        return participates;
    }

    public void setParticipates(List<User> participates) {
        this.participates = participates;
    }

    public void addPriceHistory(PriceHistory priceHistory) {
        this.priceHistory.add(priceHistory);
        priceHistory.setPost(this);
    }

    public void removePriceHistory(PriceHistory priceHistory) {
        this.priceHistory.remove(priceHistory);
        priceHistory.setPost(null);
    }

    public void addParticipate(User user) {
        participates.add(user);
        user.getPosts().add(this);
    }

    public void removeParticipate(User user) {
        participates.remove(user);
        user.getPosts().remove(this);
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
                && Objects.equals(user, post.user)
                && Objects.equals(car, post.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, user, car);
    }
}

package ru.job4j.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "price_history")
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long before;
    private long after;
    private LocalDateTime created;
    @ManyToOne
    private Post post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    public long getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PriceHistory that = (PriceHistory) o;
        return id == that.id
                && before == that.before
                && after == that.after
                && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, before, after, created);
    }
}

package ru.job4j.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Post;
import ru.job4j.model.User;
import ru.job4j.util.DbConnect;

import java.util.List;

@Repository
public class PostDbStore {

    private final SessionFactory sf;

    public PostDbStore(SessionFactory sf) {
        this.sf = sf;
    }

    public User saveOrUpdate(User user) {
        return DbConnect.tx(session -> {
            session.saveOrUpdate(user);
            return user;
        }, sf);
    }

    public void delete(User user) {
        DbConnect.tx(session -> {
            session.delete(user);
            return true;
        }, sf);
    }

    public List<Post> findAll() {
        return  DbConnect.tx(session -> session.createQuery(
                "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user ORDER BY p.id")
                .list(), sf);
    }

    public Post findById(int id) {
        return (Post) DbConnect.tx(session -> session.createQuery(
                        "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.id = :fId")
                .setParameter("fId", id).uniqueResult(), sf);
    }

    public List<Post> findAllSold() {
        return DbConnect.tx(session -> session.createQuery(
                        "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.sold = true ORDER BY p.id")
                .list(), sf);
    }

    public List<Post> findAllNew() {
        return DbConnect.tx(session -> session.createQuery(
                        "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.created >= CURRENT_DATE ORDER BY p.id")
                .list(), sf);
    }




}

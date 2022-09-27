package ru.job4j.persistence;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Post;
import ru.job4j.util.CrudRepository;

import java.util.List;

@Repository
public class PostDbStore {

    private final CrudRepository crudRepository;

    public PostDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Post saveOrUpdate(Post post) {
        return crudRepository.tx(session -> {
            session.saveOrUpdate(post);
            return post;
        });
    }

    public void delete(Post post) {
        crudRepository.run(session -> {
            session.delete(post);
        });
    }

    public List<Post> findAll() {
        return  crudRepository.query(
                "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user ORDER BY p.id",
                Post.class);
    }

    public Post findById(int id) {
        return (Post) crudRepository.tx(session -> session.createQuery(
                        "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.id = :fId")
                .setParameter("fId", id)
                .uniqueResult());
    }

    public List<Post> findAllSold() {
        return crudRepository.query(
                "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.sold = true ORDER BY p.id",
                Post.class);
    }

    public List<Post> findAllNew() {
        return crudRepository.query(
                "SELECT p FROM Post p JOIN FETCH p.car JOIN FETCH p.user WHERE p.created >= CURRENT_DATE ORDER BY p.id",
                Post.class);
    }

}

package ru.job4j.cars.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    private final CrudRepository crudRepository;

    public PostRepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Post saveOrUpdate(Post post) {
        return crudRepository.tx(session -> {
            session.saveOrUpdate(post);
            return post;
        });
    }

    public void delete(Post post) {
        crudRepository.run(session -> session.delete(post));
    }

    public List<Post> findAll() {
        return  crudRepository.query(
                        """
                        SELECT p FROM Post p
                        JOIN FETCH p.car
                        JOIN FETCH p.user
                        ORDER BY p.id
                        """,
                Post.class);
    }

    public Post findById(int id) {
        return (Post) crudRepository.tx(
                session -> session.createQuery(
                                """
                                SELECT p FROM Post p
                                JOIN FETCH p.car
                                JOIN FETCH p.user
                                WHERE p.id = :fId
                                """
                )
                .setParameter("fId", id)
                .uniqueResult());
    }

    public List<Post> findAllSale() {
        return crudRepository.query(
                        """
                        SELECT p FROM Post p
                        JOIN FETCH p.car
                        JOIN FETCH p.user
                        WHERE p.sale = true
                        ORDER BY p.id
                        """,
                Post.class);
    }

    public List<Post> findAllSold() {
        return crudRepository.query(
                        """
                        SELECT p FROM Post p
                        JOIN FETCH p.user
                        WHERE p.sale = false ORDER BY p.id
                        """,
                Post.class);
    }

    public List<Post> findAllNew() {
        return crudRepository.query(
                """
                        SELECT p FROM Post p
                        JOIN FETCH p.car
                        JOIN FETCH p.user
                        WHERE p.created >= CURRENT_DATE ORDER BY p.id
                        """,
                Post.class);
    }

    public List<Post> findAllSpecificBrand(String brand) {
        return crudRepository.query(
                        """
                        SELECT p FROM Post p
                        JOIN FETCH p.car c
                        JOIN FETCH p.user u
                        WHERE c.brand := carBrand
                        """,
                Post.class,
                Map.of("carBrand", brand));
    }

    public List<Post> findAllPostsWithPhoto() {
        return crudRepository.query(
                        """
                        SELECT p FROM Post p
                        JOIN FETCH p.car c
                        JOIN FETCH p.user u
                        WHERE c.photo IS NOT NULL
                        """,
                Post.class);
    }

    public void changeStatusToSold(int id) {
        crudRepository.run(
                        """
                        UPDATE Post
                        SET sale = false
                        WHERE id = :fId
                        """,
                Map.of("fId", id));
    }
}

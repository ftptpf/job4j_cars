package ru.job4j.persistence;

import org.springframework.stereotype.Repository;
import ru.job4j.model.User;
import ru.job4j.util.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDbStore {

    private final CrudRepository crudRepository;

    public UserDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Optional<User> create(User user) {
        try {
            crudRepository.tx(session -> session.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(user);
    }

    public void deleteAll() {
        crudRepository.run("DELETE FROM User");
    }

    public List<User> findAll() {
        return crudRepository.query("FROM User", User.class);
    }

    public Optional<User> findByLoginAndPassword(String email, String password) {
        return crudRepository.optional(
                "FROM User WHERE email = :userEmail AND password = :userPassword",
                User.class,
                Map.of("userEmail", email, "userPassword", password)
        );
    }

}

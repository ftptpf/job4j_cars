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
        return crudRepository.optionalSave(user);
/*        return Optional.ofNullable(crudRepository.tx(session -> session.save(user)));
        return crudRepository.optional(
                "INSERT INTO User (name, email, password) SELECT (:fName, :fEmail, :fPassword) FROM User",
                User.class,
                Map.of("fName", user.getName(), "fEmail", user.getEmail(), "fPassword", user.getPassword()));
        crudRepository.run(session -> session.persist(user));
        return Optional.ofNullable(user);*/
    }
    // TODO Optional exception when user exist

/*    public User create(User user) {
        return crudRepository.tx()
    }*/

    public void deleteAll() {
        crudRepository.run("DELETE FROM User");
    }

    public List<User> findAll() {
        return crudRepository.query("FROM User", User.class);
    }

    public List<User> findByLoginAndPassword(String email, String password) {
        return crudRepository.query("FROM User WHERE email = :userEmail AND password = :userPassword",
                User.class,
                Map.of("userEmail", email, "userPassword", password)
        );
    }

}

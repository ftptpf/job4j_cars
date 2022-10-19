package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.User;
import ru.job4j.persistence.UserDbStore;

import java.util.Optional;

@Service
public class UserService {

    private final UserDbStore store;

    public UserService(UserDbStore store) {
        this.store = store;
    }

    public Optional<User> create(User user) {
        return store.create(user);
    }

    public Optional<User> findByLoginAndPassword(String email, String password) {
        return store.findByLoginAndPassword(email, password);
    }
}

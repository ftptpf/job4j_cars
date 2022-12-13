package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.User;
import ru.job4j.repository.UserDbStore;

import java.util.List;
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

    public void deleteAll() {
        store.deleteAll();
    }

    public List<User> findAll() {
        return store.findAll();
    }

    public Optional<User> findById(int id) {
        return store.findById(id);
    }

    public Optional<User> findByLoginAndPassword(String email, String password) {
        return store.findByLoginAndPassword(email, password);
    }
}

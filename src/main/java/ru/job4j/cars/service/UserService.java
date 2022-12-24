package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository store;

    public UserService(UserRepository store) {
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

    public User findById(int id) {
        return store.findById(id);
    }

    public Optional<User> findByLoginAndPassword(String email, String password) {
        return store.findByLoginAndPassword(email, password);
    }
}

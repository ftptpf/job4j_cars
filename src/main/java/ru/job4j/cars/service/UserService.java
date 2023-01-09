package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.Store;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements CrudService<User> {
    private final Store<User> store;

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

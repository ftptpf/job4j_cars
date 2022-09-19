package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Driver;
import ru.job4j.persistence.DriverDbStore;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverDbStore store;

    public DriverService(DriverDbStore store) {
        this.store = store;
    }

    public Optional<Driver> create(Driver driver) {
        return store.create(driver);
    }

    public List<Driver> findByLoginAndPassword(String email, String password) {
        return store.findByLoginAndPassword(email, password);
    }
}

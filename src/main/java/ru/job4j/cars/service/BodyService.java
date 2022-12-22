package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.repository.BodyDbStore;

import java.util.List;

@Service
public class BodyService {

    private final BodyDbStore store;

    public BodyService(BodyDbStore store) {
        this.store = store;
    }

    public List<Body> findAll() {
        return store.findAll();
    }
}

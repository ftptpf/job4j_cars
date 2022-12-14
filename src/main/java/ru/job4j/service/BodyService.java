package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Body;
import ru.job4j.repository.BodyDbStore;

import java.util.List;

@Service
public class BodyService {

    private BodyDbStore store;

    public BodyService(BodyDbStore store) {
        this.store = store;
    }

    public List<Body> findAll() {
        return store.findAll();
    }
}

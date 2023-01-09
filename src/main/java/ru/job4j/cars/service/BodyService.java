package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.repository.Store;

import java.util.List;

@Service
@AllArgsConstructor
public class BodyService implements CrudService<Body> {
    private final Store<Body> store;

    public List<Body> findAll() {
        return store.findAll();
    }
}

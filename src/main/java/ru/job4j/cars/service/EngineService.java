package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.Store;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineService implements CrudService<Engine> {
    private final Store<Engine> store;

    public List<Engine> findAll() {
        return store.findAll();
    }
}

package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.repository.EngineRepository;
import ru.job4j.cars.model.Engine;

import java.util.List;

@Service
public class EngineService {
    private final EngineRepository store;

    public EngineService(EngineRepository store) {
        this.store = store;
    }

    public List<Engine> findAll() {
        return store.findAll();
    }
}

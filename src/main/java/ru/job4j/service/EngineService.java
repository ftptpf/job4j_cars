package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Engine;
import ru.job4j.repository.EngineDbStore;

import java.util.List;

@Service
public class EngineService {
    private EngineDbStore store;

    public List<Engine> findAll() {
        return store.findAll();
    }
}

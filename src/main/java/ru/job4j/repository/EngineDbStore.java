package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Engine;
import ru.job4j.util.CrudRepository;

import java.util.List;
@Repository
public class EngineDbStore {
    private final CrudRepository crudRepository;

    public EngineDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Engine> findAll() {
        return crudRepository.query("FROM Engine", Engine.class);
    }
}

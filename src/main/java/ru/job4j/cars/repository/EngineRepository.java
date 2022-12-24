package ru.job4j.cars.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;

@Repository
public class EngineRepository {
    private final CrudRepository crudRepository;

    public EngineRepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Engine> findAll() {
        return crudRepository.query("FROM Engine", Engine.class);
    }
}

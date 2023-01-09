package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EngineRepository implements Store<Engine> {
    private final CrudRepository crudRepository;

    public List<Engine> findAll() {
        return crudRepository.query("FROM Engine", Engine.class);
    }

}

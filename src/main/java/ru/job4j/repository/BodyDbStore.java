package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Body;
import ru.job4j.util.CrudRepository;

import java.util.List;

@Repository
public class BodyDbStore {
    private final CrudRepository crudRepository;

    public BodyDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Body> findAll() {
        return  crudRepository.query("FROM Body", Body.class);
    }
}

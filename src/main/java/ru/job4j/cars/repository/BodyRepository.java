package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BodyRepository implements Store<Body> {
    private final CrudRepository crudRepository;

    public List<Body> findAll() {
        return  crudRepository.query("FROM Body", Body.class);
    }
}

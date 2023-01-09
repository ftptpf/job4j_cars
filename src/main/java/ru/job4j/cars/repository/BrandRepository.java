package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BrandRepository implements Store<Brand> {
    private final CrudRepository crudRepository;

    public List<Brand> findAll() {
        return crudRepository.query("FROM Brand", Brand.class);
    }

}

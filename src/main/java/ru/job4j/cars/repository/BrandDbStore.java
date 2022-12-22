package ru.job4j.cars.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.util.CrudRepository;

import java.util.List;

@Repository
public class BrandDbStore {
    private final CrudRepository crudRepository;

    public BrandDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Brand> findAll() {
        return crudRepository.query("FROM Brand", Brand.class);
    }
}

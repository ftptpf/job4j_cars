package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.repository.Store;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService implements CrudService<Brand> {
    private final Store<Brand> store;

    public List<Brand> findAll() {
        return store.findAll();
    }
}

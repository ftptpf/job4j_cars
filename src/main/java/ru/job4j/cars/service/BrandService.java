package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.repository.BrandDbStore;
import ru.job4j.cars.model.Brand;

import java.util.List;

@Service
public class BrandService {
    private final BrandDbStore store;

    public BrandService(BrandDbStore store) {
        this.store = store;
    }

    public List<Brand> findAll() {
        return store.findAll();
    }
}

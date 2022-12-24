package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.repository.BrandRepository;
import ru.job4j.cars.model.Brand;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository store;

    public BrandService(BrandRepository store) {
        this.store = store;
    }

    public List<Brand> findAll() {
        return store.findAll();
    }
}

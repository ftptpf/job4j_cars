package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Brand;
import ru.job4j.repository.BrandDbStore;

import java.util.List;

@Service
public class BrandService {
    private BrandDbStore store;

    public List<Brand> findAll() {
        return store.findAll();
    }
}

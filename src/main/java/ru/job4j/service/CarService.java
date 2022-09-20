package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.persistence.CarDbStore;

@Service
public class CarService {

    private final CarDbStore store;

    public CarService(CarDbStore store) {
        this.store = store;
    }
}

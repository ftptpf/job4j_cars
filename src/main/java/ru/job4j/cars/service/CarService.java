package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.Store;


import java.util.List;

@Service
@AllArgsConstructor
public class CarService implements CrudService<Car> {
    private final Store<Car, String, Integer> store;

    public Car saveOrUpdate(Car car) {
        return store.saveOrUpdate(car);
    }

    public void delete(Car car) {
        store.delete(car);
    }

    public void deleteAll() {
        store.deleteAll();
    }

    public Car findById(int id) {
        return store.findById(id);
    }

    public List<Car> findAll() {
        return store.findAll();
    }
}

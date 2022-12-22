package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CarDbStore;

import java.util.List;

@Service
public class CarService {

    private final CarDbStore store;

    public CarService(CarDbStore store) {
        this.store = store;
    }

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

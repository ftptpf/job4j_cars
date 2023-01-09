package ru.job4j.cars.service;

import ru.job4j.cars.model.Car;

import java.util.List;

public interface CrudService<T> {
    public List<T> findAll();
}

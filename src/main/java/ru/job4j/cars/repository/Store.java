package ru.job4j.cars.repository;

import java.util.List;

public interface Store<T> {
    public List<T> findAll();

}

package ru.job4j.cars.repository;

import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

public interface Store<T, S, K> {
    public Optional<T> create(T t);
    public List<T> findAll();
    public T findById(K id);
    public void deleteAll();
    public Optional<T> findByLoginAndPassword(S login, S password);

}

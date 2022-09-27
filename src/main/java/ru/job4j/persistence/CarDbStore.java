package ru.job4j.persistence;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Car;
import ru.job4j.util.CrudRepository;

@Repository
public class CarDbStore {

    private final CrudRepository crudRepository;

    public CarDbStore(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Car saveOrUpdate(Car car) {
        return crudRepository.tx(session -> {
            session.saveOrUpdate(car);
            return car;
        });
    }

    public void delete(Car car) {
        crudRepository.run(session -> {
            session.delete(car);
        });
    }

    public Car findById(int id) {
        return (Car) crudRepository.tx(session -> session.createQuery(
                        "SELECT c FROM Car c WHERE c.id = :fId")
                .setParameter("fId", id)
                .uniqueResult());
    }
}

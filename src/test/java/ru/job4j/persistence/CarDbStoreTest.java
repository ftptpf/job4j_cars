package ru.job4j.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.model.Car;
import ru.job4j.util.CrudRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarDbStoreTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();

    @BeforeAll
    public static void cleanBase() {
        CarDbStore store = new CarDbStore(new CrudRepository(SESSION_FACTORY));
        store.deleteAll();
    }

    @Test
    void whenAddNewCar() {
        CarDbStore store = new CarDbStore(new CrudRepository(SESSION_FACTORY));
        Car car = new Car();
        car.setDescription("some car");

        store.saveOrUpdate(car);

        List<Car> carList = store.findAll();
        assertThat(carList)
                .isNotEmpty()
                .hasSize(1);

        Car carFromBase = carList.get(0);
        assertThat(carFromBase.getDescription())
                .isEqualTo("some car");

        store.deleteAll();
    }

}
package ru.job4j.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.model.User;
import ru.job4j.util.CrudRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserDbStoreTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @AfterEach
    public void deleteInBase() {

    }

    @Test
    public void whenAddNewUser() {
        UserDbStore store = new UserDbStore(new CrudRepository(sf));
        User user = new User();
        user.setName("Oleg");
        user.setEmail("oler@oleg.ru");
        user.setPassword("oleg");

        store.create(user);
        List<User> userList = store.findAll();

        assertThat(userList)
                .isNotEmpty()
                .hasSize(1);

    }


}
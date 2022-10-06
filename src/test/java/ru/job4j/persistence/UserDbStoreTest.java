package ru.job4j.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.model.User;
import ru.job4j.util.CrudRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserDbStoreTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();

    @BeforeAll
    public static void cleanBase() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        store.deleteAll();
    }

    @Test
    public void whenAddNewUser() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user = new User();
        user.setName("Oleg");
        user.setEmail("oler@oleg.ru");
        user.setPassword("oleg");

        store.create(user);
        List<User> userList = store.findAll();
        assertThat(userList)
                .isNotEmpty()
                .hasSize(1);

        User userFromBase = userList.get(0);
        assertThat(userFromBase
                .getName())
                .isEqualTo("Oleg");
        assertThat(userFromBase
                .getEmail())
                .isEqualTo("oler@oleg.ru");
        assertThat(userFromBase
                .getPassword())
                .isEqualTo("oleg");

        store.deleteAll();
    }


}
package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.util.CrudRepository;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class UserDbStoreTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(REGISTRY)
            .buildMetadata()
            .buildSessionFactory();

    @BeforeAll
    public static void cleanBase() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        store.deleteAll();
    }

    @Test
    public void whenAddNewUser() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user = new User();
        user.setLogin("Oleg");
        user.setPassword("oleg");

        store.create(user);
        List<User> userList = store.findAll();
        assertThat(userList)
                .isNotEmpty()
                .hasSize(1);

        User userFromBase = userList.get(0);
        assertThat(userFromBase
                .getLogin())
                .isEqualTo("Oleg");
        assertThat(userFromBase
                .getPassword())
                .isEqualTo("oleg");

        store.deleteAll();
    }

    @Test
    public void whenAddNewUserWithSameLogin() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setLogin("Oleg");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setLogin("Oleg");
        user2.setPassword("stepan");

        Optional<User> optionalUser1 = store.create(user1);
        Optional<User> optionalUser2 = store.create(user2);

        assertThat(optionalUser1.isEmpty()).isFalse();
        assertThat(optionalUser2.isEmpty()).isTrue();

        store.deleteAll();

    }

    @Test
    public void whenFindAll() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setLogin("Oleg");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setLogin("Stepan");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        List<User> userList = store.findAll();
        assertThat(userList)
                .isNotEmpty()
                .hasSize(2);

        User userFromBase1 = userList.get(0);
        assertThat(userFromBase1
                .getLogin())
                .isEqualTo("Oleg");
        assertThat(userFromBase1
                .getPassword())
                .isEqualTo("oleg");

        User userFromBase2 = userList.get(1);
        assertThat(userFromBase2
                .getLogin())
                .isEqualTo("Stepan");
        assertThat(userFromBase2
                .getPassword())
                .isEqualTo("stepan");

        store.deleteAll();
    }

    @Test
    public void whenFindUserByLoginAndPassword() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setLogin("Oleg");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setLogin("Stepan");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        Optional<User> userDb = store.findByLoginAndPassword("Oleg", "oleg");
        assertThat(userDb.get())
                .isEqualTo(user1);

        store.deleteAll();
    }

    @Test
    public void whenNotFindUserByLoginAndPassword() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setLogin("Oleg");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setLogin("Stepan");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        Optional<User> userDb = store.findByLoginAndPassword("Oleg", "not correct password");
        assertThat(userDb.isEmpty())
                .isTrue();

        store.deleteAll();
    }

}
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
import java.util.Optional;

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
        user.setEmail("oleg@oleg.ru");
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
                .isEqualTo("oleg@oleg.ru");
        assertThat(userFromBase
                .getPassword())
                .isEqualTo("oleg");

        store.deleteAll();
    }

    @Test
    public void whenAddNewUserWithSameEmail() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setName("Oleg");
        user1.setEmail("oleg@oleg.ru");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setName("Stepan");
        user2.setEmail("oleg@oleg.ru");
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
        user1.setName("Oleg");
        user1.setEmail("oleg@oleg.ru");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setName("Stepan");
        user2.setEmail("stepan@stepan.ru");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        List<User> userList = store.findAll();
        assertThat(userList)
                .isNotEmpty()
                .hasSize(2);

        User userFromBase1 = userList.get(0);
        assertThat(userFromBase1
                .getName())
                .isEqualTo("Oleg");
        assertThat(userFromBase1
                .getEmail())
                .isEqualTo("oleg@oleg.ru");
        assertThat(userFromBase1
                .getPassword())
                .isEqualTo("oleg");

        User userFromBase2 = userList.get(1);
        assertThat(userFromBase2
                .getName())
                .isEqualTo("Stepan");
        assertThat(userFromBase2
                .getEmail())
                .isEqualTo("stepan@stepan.ru");
        assertThat(userFromBase2
                .getPassword())
                .isEqualTo("stepan");

        store.deleteAll();
    }

    @Test
    public void whenFindUserByEmailAndPassword() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setName("Oleg");
        user1.setEmail("oleg@oleg.ru");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setName("Stepan");
        user2.setEmail("stepan@stepan.ru");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        List<User> userListDb = store.findByLoginAndPassword("oleg@oleg.ru", "oleg");
        assertThat(userListDb)
                .isNotEmpty()
                .hasSize(1);

        store.deleteAll();
    }

    @Test
    public void whenNotFindUserByEmailAndPassword() {
        UserDbStore store = new UserDbStore(new CrudRepository(SESSION_FACTORY));
        User user1 = new User();
        user1.setName("Oleg");
        user1.setEmail("oleg@oleg.ru");
        user1.setPassword("oleg");
        User user2 = new User();
        user2.setName("Stepan");
        user2.setEmail("stepan@stepan.ru");
        user2.setPassword("stepan");

        store.create(user1);
        store.create(user2);
        List<User> userListDb = store.findByLoginAndPassword("oleg@oleg.ru", "not correct password");
        assertThat(userListDb)
                .isEmpty();

        store.deleteAll();
    }

}
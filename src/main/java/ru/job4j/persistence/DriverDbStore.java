package ru.job4j.persistence;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Driver;
import ru.job4j.util.DbConnect;

import java.util.List;
import java.util.Optional;

@Repository
public class DriverDbStore {

    private final SessionFactory sf;

    public DriverDbStore(SessionFactory sf) {
        this.sf = sf;
    }

    public Optional<Driver> create(Driver driver) {
        try {
            DbConnect.tx(session -> session.save(driver), sf);
        } catch (HibernateException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(driver);
    }

    public List<Driver> findByLoginAndPassword(String email, String password) {
        return DbConnect.tx(session -> session.createQuery(
                        "FROM Driver WHERE email = :driverEmail AND password = :driverPassword")
                .setParameter("driverEmail", email)
                .setParameter("driverPassword", password)
                .list(), sf);
    }

}

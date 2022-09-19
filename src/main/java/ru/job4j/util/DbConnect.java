package ru.job4j.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.TimeZone;
import java.util.function.Function;

public class DbConnect {

    private DbConnect() {
    }

    public static <T> T tx(final Function<Session, T> command, SessionFactory sf) {
        final Session session = sf
                .withOptions()
                .jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                .openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

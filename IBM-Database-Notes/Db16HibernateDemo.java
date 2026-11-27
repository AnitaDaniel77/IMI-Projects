// Plain Hibernate (no Spring): SessionFactory, Session, Transaction, entity states and HQL
package com.example.bookstore;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Db16HibernateDemo {

    public static void main(String[] args) {
        // Built once for the whole app (expensive)
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Long savedId = saveBook(factory);
        updatePrice(factory, savedId);
        listCheapBooks(factory);

        factory.close(); // shut down when the app ends
    }

    // CREATE inside a transaction
    static Long saveBook(SessionFactory factory) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            HibernateBook book = new HibernateBook("Clean Code", "Robert Martin", new BigDecimal("450.00")); // transient
            session.persist(book); // now persistent

            tx.commit(); // Hibernate writes the INSERT here
            System.out.println("Saved: " + book);
            return book.getId();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // undo everything in this transaction
            }
            System.out.println("Save failed: " + e.getMessage());
            return null;
        } // session closes, book becomes detached
    }

    // UPDATE: change a persistent object, Hibernate notices on commit
    static void updatePrice(SessionFactory factory, Long id) {
        if (id == null) {
            return;
        }
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            HibernateBook book = session.get(HibernateBook.class, id); // persistent
            if (book != null) {
                book.setPrice(new BigDecimal("399.99")); // no save call needed
            }

            tx.commit(); // Hibernate writes the UPDATE because the object changed
            System.out.println("Updated: " + book);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // READ with HQL: written against the class and its fields
    static void listCheapBooks(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            List<HibernateBook> books = session
                    .createQuery("FROM HibernateBook b WHERE b.price < :max ORDER BY b.price", HibernateBook.class)
                    .setParameter("max", new BigDecimal("500"))
                    .getResultList();

            System.out.println("Books under R500:");
            for (HibernateBook b : books) {
                System.out.println("  " + b);
            }
        }
    }
}
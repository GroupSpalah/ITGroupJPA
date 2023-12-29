
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;
import org.example.homeworks.misha.hw_22_12_2023.domain.Order;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;

import java.sql.SQLException;

public class OrderDAOImpl implements CrudDAO<Order> {

    @Override
    public void add(Order order) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Customer customer = em.find(Customer.class, 1);

        order.setCustomer(customer);

        em.persist(order);


        transaction.commit();

    }

}


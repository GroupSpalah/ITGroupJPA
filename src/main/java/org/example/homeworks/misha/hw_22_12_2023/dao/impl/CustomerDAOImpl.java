
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.CustomerDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.*;

import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public void add(Customer customer) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(customer);

        transaction.commit();
    }

    @Override
    public Customer findById(int customerId) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Customer customer = em.find(Customer.class, customerId);

        transaction.commit();
        return customer;
    }

}





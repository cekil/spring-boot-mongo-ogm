package com.burakcekil.springbootmongoogm.repository;

import com.burakcekil.springbootmongoogm.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Summary
 * <p>
 * Description
 *
 * @author Burak Cekil (burakcekil.com)
 * @version 1.0
 * @since 4/18/2020
 */

@Component
public class CustomerRepository {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public Customer save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();

        // load it back
        entityManager.getTransaction().begin();

        Customer loadedCustomer = entityManager.find(Customer.class, customer.getId());
        entityManager.getTransaction().commit();

        entityManager.close();

        return loadedCustomer;
    }
}

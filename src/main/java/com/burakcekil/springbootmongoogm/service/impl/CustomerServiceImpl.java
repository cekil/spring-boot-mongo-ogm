package com.burakcekil.springbootmongoogm.service.impl;

import com.burakcekil.springbootmongoogm.model.entity.Customer;
import com.burakcekil.springbootmongoogm.repository.CustomerRepository;
import com.burakcekil.springbootmongoogm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
      return customerRepository.save(customer);
    }
}

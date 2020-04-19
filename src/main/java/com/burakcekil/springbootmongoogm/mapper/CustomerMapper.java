package com.burakcekil.springbootmongoogm.mapper;

import com.burakcekil.springbootmongoogm.model.entity.Customer;
import com.burakcekil.springbootmongoogm.model.reqres.CustomerRequest;
import com.burakcekil.springbootmongoogm.model.reqres.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
public class CustomerMapper {

    public Customer toEntity(CustomerRequest customerRequest) {
        return Customer.builder().resourceId(UUID.randomUUID().toString()).firstname(customerRequest.getFirstname()).lastname(customerRequest.getLastname()).age(customerRequest.getAge()).build();
    }

    public CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder().resourceId(customer.getResourceId()).firstname(customer.getFirstname()).lastname(customer.getLastname()).age(customer.getAge()).build();
    }
}

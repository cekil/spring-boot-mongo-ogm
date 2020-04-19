package com.burakcekil.springbootmongoogm.controller;

import com.burakcekil.springbootmongoogm.mapper.CustomerMapper;
import com.burakcekil.springbootmongoogm.model.entity.Customer;
import com.burakcekil.springbootmongoogm.model.entity.Pet;
import com.burakcekil.springbootmongoogm.model.entity.Vaccine;
import com.burakcekil.springbootmongoogm.model.reqres.CustomerRequest;
import com.burakcekil.springbootmongoogm.model.reqres.CustomerResponse;
import com.burakcekil.springbootmongoogm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Summary
 * <p>
 * Description
 *
 * @author Burak Cekil (burakcekil.com)
 * @version 1.0
 * @since 4/18/2020
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer newCustomer = customerService.saveCustomer(this.initCustomer(customerRequest));
        return this.enrichCustomer(newCustomer);
    }

    @GetMapping("/{resourceId}")
    public CustomerResponse getCustomer(@PathVariable("resourceId") String resourceId) {
        return null;
    }

    @GetMapping
    public List<CustomerResponse> getCustomers() {

        return null;
    }


    /**
     * Helpers
     **/
    private Customer initCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toEntity(customerRequest);
        Set<Pet> pets = new HashSet<>();
        List<Vaccine> vaccines = new LinkedList<>();
        vaccines.add(Vaccine.builder().date(LocalDate.now()).name("Scabie").build());
        Pet pet = Pet.builder().name("stafforside new york").age("4 months").kind("english").vaccines(vaccines).build();
        pets.add(pet);
        customer.setPets(pets);
        return customer;
    }

    private CustomerResponse enrichCustomer(Customer customer) {
        return customerMapper.toResponse(customer);
    }

}

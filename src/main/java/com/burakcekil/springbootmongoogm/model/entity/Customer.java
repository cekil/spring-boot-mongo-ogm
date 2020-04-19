package com.burakcekil.springbootmongoogm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String resourceId;


    @Column(name = "first_name")
    private String firstname;

    private String lastname;

    private int age;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Set<Pet> pets = new HashSet<>();
}

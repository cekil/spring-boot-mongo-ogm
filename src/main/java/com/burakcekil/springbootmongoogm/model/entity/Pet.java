package com.burakcekil.springbootmongoogm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
public class Pet {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String resourceId;

    private String name;

    private String kind;

    private String age;

    @ElementCollection(fetch = FetchType.LAZY)
    @OrderColumn(name = "vaccineNo")
    private List<Vaccine> vaccines;

    @ManyToOne
    private Customer customer;
}

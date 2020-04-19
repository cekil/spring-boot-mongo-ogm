package com.burakcekil.springbootmongoogm.model.reqres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
public class CustomerRequest {

    private String firstname;

    private String lastname;

    private int age;
}

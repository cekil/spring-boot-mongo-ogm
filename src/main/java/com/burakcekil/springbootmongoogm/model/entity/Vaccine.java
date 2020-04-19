package com.burakcekil.springbootmongoogm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

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
@Embeddable
public class Vaccine {

    private String name;
    private LocalDate date;
}

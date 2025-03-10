package com.techbees.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private String title;

    private BigDecimal price;

    private Integer quantity;

}

package com.techbees.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {

    private String title;

    private BigDecimal price;

    private Integer quantity;

}

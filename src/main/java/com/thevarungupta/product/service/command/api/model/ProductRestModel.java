package com.thevarungupta.product.service.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductRestModel {

    private String name;
    private BigDecimal price;
    private Integer quantity;
}

package com.thevarungupta.product.service.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}

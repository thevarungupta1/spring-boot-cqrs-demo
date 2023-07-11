package com.thevarungupta.product.service.query.api.projection;

import com.thevarungupta.product.service.command.api.data.Product;
import com.thevarungupta.product.service.command.api.data.ProductRepository;
import com.thevarungupta.product.service.command.api.model.ProductRestModel;
import com.thevarungupta.product.service.query.api.queries.GetProductQuery;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery productQuery){
        List<Product> products = productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel.builder()
                                .quantity(product.getQuantity())
                                .name(product.getName())
                                .price(product.getPrice())
                                .build())
                        .collect(Collectors.toList());
        return productRestModels;
    }

}

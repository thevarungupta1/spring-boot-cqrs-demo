package com.thevarungupta.product.service.query.api.controller;

import com.thevarungupta.product.service.command.api.model.ProductRestModel;
import com.thevarungupta.product.service.query.api.queries.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        GetProductQuery getProductQuery = new GetProductQuery();

        List<ProductRestModel> productRestModels = queryGateway
                .query(getProductQuery,
                        ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
        return productRestModels;
    }
}

package com.techbees.product.rest.controllers;

import com.techbees.product.commands.CreateProductCommand;
import com.techbees.product.model.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private CommandGateway commandGateway;
    @Autowired
    private Environment environment;

    @GetMapping("/service/status")
    public String status() {
        return "Product service is up, PORT : " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .title(product.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        String value;
        try {
            value = commandGateway.sendAndWait(createProductCommand);
        }catch (Exception e) {
            value = e.getLocalizedMessage();
        }

        return value;
    }

    @PutMapping
    public String updateProduct() {
        return "Http PUT handled";
    }

    @GetMapping
    public String getProduct() {
        return "Http GET handled, PORT : " + environment.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Http DELETE handled";
    }
}

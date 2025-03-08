package com.techbees.product.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    Environment environment;

    @GetMapping("/service/status")
    public String status() {
        return "Product service is up, PORT : " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct() {
        return "Http POST handled";
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

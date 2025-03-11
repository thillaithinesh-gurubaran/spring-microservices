package com.techbees.product.query;

import com.techbees.product.entity.ProductEntity;
import com.techbees.product.events.ProductCreatedEvent;
import com.techbees.product.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        // Copy properties
        BeanUtils.copyProperties(event, productEntity);
        // Save
        productRepository.save(productEntity);
    }
}

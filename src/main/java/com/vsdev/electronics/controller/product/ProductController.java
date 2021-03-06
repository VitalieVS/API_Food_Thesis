package com.vsdev.electronics.controller.product;

import com.vsdev.electronics.entity.product.Product;
import com.vsdev.electronics.repository.product.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ProductController {


    private final ProductRepository productRepository;

    @Inject
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}

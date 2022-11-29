package com.sm.controller;

import com.sm.entity.Product;
import com.sm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable Long id) {
        return service.findProductById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAllProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product productRequest) {
        return service.updateProductById(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteProductById(id);
    }

}



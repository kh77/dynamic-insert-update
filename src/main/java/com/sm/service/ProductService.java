package com.sm.service;

import com.sm.entity.Product;
import com.sm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public Product addProduct(Product product) {
        return repository.save(product);

    }

    public Product findProductById(Long id) {
        return repository.findById(id).get();
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product updateProductById(Long id, Product request) {
        Product existingProduct = repository.findById(id).get();
        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setProductType(existingProduct.getProductType());
        return repository.save(existingProduct);
    }

    public String deleteProductById(Long id) {
        repository.deleteById(id);
        return "Product has been deleted";
    }
}

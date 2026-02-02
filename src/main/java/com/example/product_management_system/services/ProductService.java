package com.example.product_management_system.services;

import com.example.product_management_system.model.ProductModel;
import com.example.product_management_system.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductModel addProduct(ProductModel product) {
        return repository.save(product);
    }

    public List<ProductModel> getProducts() {
        return repository.findAll();
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

    public ProductModel updateProduct(String id, ProductModel product) {
        ProductModel existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setCategory(product.getCategory());

        return repository.save(existing);
    }
}

package com.example.product_management_system.controller;

import com.example.product_management_system.model.ProductModel;
import com.example.product_management_system.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductModel addProduct(@RequestBody ProductModel product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<ProductModel> getProducts() {
        return service.getProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }

    @PutMapping("/{id}")
    public ProductModel updateProduct(
            @PathVariable String id,
            @RequestBody ProductModel product) {
        return service.updateProduct(id, product);
    }
}

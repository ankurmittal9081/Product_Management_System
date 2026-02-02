package com.example.product_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductModel {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;
}

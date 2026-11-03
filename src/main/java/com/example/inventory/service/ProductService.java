package com.example.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.inventory.model.Product;

@Service
public class ProductService {

    // Temporary storage using List
    private final List<Product> productList = new ArrayList<>();

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Optional<Product> getProductById(int id) {
        return productList.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();
    }

    public Optional<Product> updateProduct(int id, Product updated) {
        Optional<Product> existing = getProductById(id);
        existing.ifPresent(p -> {
            p.setProductName(updated.getProductName());
            p.setCategory(updated.getCategory());
            p.setStock(updated.getStock());
            p.setPrice(updated.getPrice());
        });
        return existing;
    }

    public boolean deleteProduct(int id) {
        return productList.removeIf(p -> p.getProductId() == id);
    }
}
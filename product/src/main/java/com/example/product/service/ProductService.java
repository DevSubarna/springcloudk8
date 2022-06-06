package com.example.product.service;


import com.example.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product get(Long id);

    Product save(Product product);

    Product deduct(Long id, Long quantity);

    Product add(Long id, Long quantity);
}

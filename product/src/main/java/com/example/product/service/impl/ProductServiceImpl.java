package com.example.product.service.impl;

import com.example.product.custom.EntityNotFoundException;
import com.example.product.model.Product;
import com.example.product.model.ProductMessage;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product add(Long productId, Long quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(productId+ " not found"));;
        //ProductMessage response = product.add(quantity);
        //Product productDTO = MapperUtil.map(productRepository.save(product), Product.class);
        return product;
    }

    @Override
    public Product deduct(Long productId, Long quantity) {
        Product product = productRepository.findById(productId).get();
        ProductMessage response = product.deduct(quantity);
        if(response.equals(ProductMessage.ERROR)) return null;
        //if(response == ProductMessage.BELOW_THRESHOLD){
          //  log.info("sending message [" + "Deduct stock from: " + product.getName() + "] to " + stockUrl);
            //restTemplate.postForEntity(stockUrl, "Deduct stock from: " + product.getName(), String.class);
       // }
        return product;
    }
}

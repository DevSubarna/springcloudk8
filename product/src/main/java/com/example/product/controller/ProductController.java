package com.example.product.controller;

import com.example.product.constants.RestEndpoints;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestEndpoints.PRODUCTS)
public class ProductController {

    ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping(RestEndpoints.BY_ID)
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
    @PostMapping("/{id}/deduct/{quantity}")
    public ResponseEntity<?> deductProductQuantity(@PathVariable Long id, @PathVariable Long quantity) {
        Product productDTO = productService.deduct(id, quantity);
        //TODO prepare an error response object
        if(productDTO == null) return new ResponseEntity<>("The requested quantity is beyond the stock on hand.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/add/{quantity}")
    public ResponseEntity<Product> addProductQuantity(@PathVariable Long id, @PathVariable Long quantity) {
        return new ResponseEntity<>(productService.add(id, quantity), HttpStatus.OK);
    }

}

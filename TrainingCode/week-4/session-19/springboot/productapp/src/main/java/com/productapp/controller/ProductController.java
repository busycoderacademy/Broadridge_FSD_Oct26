package com.productapp.controller;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //ResponseEntity: bag aka collection that hold 2 things data + http status code
    //get all product rest api
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK).body(productService.findAll());
    }
    //get product by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    //add product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.addProduct(product));
    }

    //update product
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
    }

    //delete by id
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

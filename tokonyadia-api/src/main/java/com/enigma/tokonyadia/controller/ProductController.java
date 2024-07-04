package com.enigma.tokonyadia.controller;

import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(path = "/products")
    public Product createNewProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @PostMapping(path = "products/bulk")
    public List<Product> creatBulkProduct(@RequestBody List<Product> products){
        return productService.createBulk(products);
    }
    //

    // Get All Product With Param
    @GetMapping(path = "/products")
    public List<Product> getAllProduct(@RequestParam(name = "name", required = false) String name){
        if(name != null){
            return productService.getAllByName(name);
        }
        return productService.getAll();
    }

    // Get All Product Without Param
   /* @GetMapping(path = "/products")
    public List<Product> getAllProduct() {
        return products;
    }*/

    // Delete menggunakan id
    @DeleteMapping(path = "/products/{id}")
    public String deleteById(@PathVariable(name = "id") String id) {
        return productService.deleteById(id);
    }

    // Put Mapping dengan Path Variable
    // Update With param

   /* @PutMapping("/products/{id}")
    public Product updateProductWithParam(@RequestBody Product product, @PathVariable(name = "id") String id){
        return productService.updateProduct(product);
    }*/

    // Cara 2 Request Body

    @PutMapping(path = "/products")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}

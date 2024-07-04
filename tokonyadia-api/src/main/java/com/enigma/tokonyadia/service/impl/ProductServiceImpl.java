package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products;

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public Product create(Product product) {
        product.setId(UUID.randomUUID().toString());
        products.add(product);
        return product;
    }

    @Override
    public List<Product> createBulk(List<Product> products) {
        for (Product product : products) {
            product.setId(UUID.randomUUID().toString());
            this.products.add(product);
        }
        // this.products.addAll(products)
        return products;
    }

    @Override
    public Product getByid(String id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public List<Product> getAllByName(String name) {

        List<Product> filteredProduct = products.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
        return filteredProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId().equals(product.getId())).findFirst();

        if (productOptional.isPresent()) {
            int index = products.indexOf(productOptional.get());
            product.setId(product.getId());
            products.set(index, product);
            return product;
        }
        return null;

    }

  /*  @Override
    public Product updateProduct(Product product) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId().equals(product.getId())).findFirst();

        if(productOptional.isPresent()){
            int index = products.indexOf(productOptional.get());
            //product.setId(product.getId());
            products.set(index, product);
            return product;
        }
        return null;

    }*/

    @Override
    public String deleteById(String id) {
        Optional<Product> productOptional = products.stream().filter(product -> product.getId().equals(id)).findFirst();
        if (productOptional.isPresent()) {
            products.remove(productOptional.get());
            return "Sukses menghapus data product: " + productOptional.get().getId();
        }
        return "product tidak ditemukan";
    }
}

package com.enigma.tokonyadia.controller;

import com.enigma.tokonyadia.entity.Customer;
import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    //TODO cari berdasarkan nama/email/nomor telepon

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Insert Into Customer

    @PostMapping("/customers")
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @PostMapping("/customers/bulk")
    public List<Customer> createBulkCustomer(@RequestBody List<Customer> customers){
        return customerService.createBulk(customers);
    }

    @GetMapping(path = "/customers/{id}")
    public Customer getById(@PathVariable(name = "id") String id) {
        return customerService.getById(id);
    }

    //
    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomer (@RequestParam(name = "name", required = false) String name){
        if(name != null){
            return customerService.getAllByName(name);
        }
        return customerService.getAll();
    }

    @PutMapping(path = "/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping(path = "/customers/{id}")
    public String deleteById(@PathVariable(name = "id") String id) {
        return customerService.deleteById(id);
    }



}

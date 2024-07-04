package com.enigma.tokonyadia.service;

import com.enigma.tokonyadia.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> createBulk(List<Customer> customers);
    Customer getById(String id);
    List<Customer> getAll();
    List<Customer> getAllByName(String name);
    Customer updateCustomer(Customer customer);
    String deleteById(String id);

}

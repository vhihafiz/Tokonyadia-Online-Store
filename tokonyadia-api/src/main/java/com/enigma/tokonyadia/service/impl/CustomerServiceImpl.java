package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.Customer;
import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final List<Customer> customers;

    public CustomerServiceImpl(List<Customer> customers) {
        this.customers = customers;
    }

    // Insert Into Customer
    @Override
    public Customer create(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> createBulk(List<Customer> customers) {
        for (Customer customer : customers) {
            customer.setId(UUID.randomUUID().toString());
            this.customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer getById(String id) {
        Optional<Customer> customerOptional = customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
        if(customerOptional.isPresent()){
            int index = customers.indexOf(customerOptional.get());
            Customer customer = customers.get(index);
            return customer;
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public List<Customer> getAllByName(String name) {
        List<Customer> filteredCustomer = customers.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList());
        return filteredCustomer;
    }



    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional
                = customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst();

        if (customerOptional.isPresent()) {
            int index = customers.indexOf(customerOptional.get());
            customers.set(index, customer);
            return customer;
        }
        return null;
    }


    @Override
    public String deleteById(String id) {
        Optional<Customer> customerOptional = customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
        if(customerOptional.isPresent()){
            customers.remove(customerOptional.get());
            return "Sukses menghapus data customer: " + customerOptional.get().getId();
        }
        return "Customer tidak ditemukan";
    }

}

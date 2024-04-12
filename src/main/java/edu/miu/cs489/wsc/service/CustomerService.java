package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
}

package edu.miu.cs489.wsc.service.impl;

import edu.miu.cs489.wsc.model.Customer;
import edu.miu.cs489.wsc.repository.CustomerRepository;
import edu.miu.cs489.wsc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public List<Customer> findAllByName(String name) {
        return repository.findAllByFirstnameContainsOrLastnameContains(name, name);
    }

}

package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.model.Customer;
import edu.miu.cs489.wsc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(name = "search", required = false) String search) {
        List<Customer> customers;
        if (search == null || search.isEmpty() || search.isBlank()) {
            customers = service.getAll();
        } else {
            customers = service.findAllByName(search);
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = service.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = service.save(customer);
        return ResponseEntity.ok(addedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer findCustomer = service.findById(id);
        if (findCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setCustomerId(id);
        service.save(customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        Customer findCustomer = service.findById(id);
        if (findCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(findCustomer);
        return ResponseEntity.ok("Deleted successfully!");
    }


}

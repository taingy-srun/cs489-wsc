package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.dto.CustomerCreationDTO;
import edu.miu.cs489.wsc.dto.CustomerDTO;
import edu.miu.cs489.wsc.dto.CustomerUpdateDTO;
import edu.miu.cs489.wsc.model.Customer;
import edu.miu.cs489.wsc.model.ShoppingCart;
import edu.miu.cs489.wsc.service.CustomerService;
import edu.miu.cs489.wsc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService service;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public CustomerController(CustomerService service, ShoppingCartService shoppingCartService) {
        this.service = service;
        this.shoppingCartService = shoppingCartService;
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
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerCreationDTO customerCreationDTO) {
        Customer addedCustomer = service.save(customerCreationDTO.toCustomer());
        return ResponseEntity.ok(addedCustomer.toCustomerDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerCreationDTO customerCreationDTO) {
        Customer findCustomer = service.findById(id);
        if (findCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO(id, customerCreationDTO);
        Customer updatedCustomer = service.save(customerUpdateDTO.toCustomer());
        return ResponseEntity.ok(updatedCustomer.toCustomerDTO());
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

    @GetMapping("/{id}/shopping-carts")
    public ResponseEntity<List<ShoppingCart>> getCustomerShoppingCart(@PathVariable Integer id) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAllByCustomerId(id);
        return ResponseEntity.ok(shoppingCarts);
    }

}

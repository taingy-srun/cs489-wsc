package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Customer;

public record CustomerUpdateDTO(Integer id, CustomerCreationDTO customerCreationDTO) {

    public Customer toCustomer() {
        Customer customer = customerCreationDTO.toCustomer();
        customer.setCustomerId(id);
        return customer;
    }
}

package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Customer;

public record CustomerCreationDTO(String firstname, String lastname, String phone, String email) {
    public Customer toCustomer() {
        return new Customer(firstname, lastname, phone, email);
    }
}

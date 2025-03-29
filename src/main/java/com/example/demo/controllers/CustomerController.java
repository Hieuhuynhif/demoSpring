package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("customers")
    public String deleteCustomers() {
        customerService.deleteCustomers();
        return "Delete Successfully";
    }

}

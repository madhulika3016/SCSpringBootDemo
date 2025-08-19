package com.firstspringbootdemo.controllers;

import com.firstspringbootdemo.model.Customer;
import com.firstspringbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("getcustomers")
    public List<Customer> getCustomers() {
      List<Customer> lc= customerService.getCustomers();
        return lc;
    }

    @PostMapping("addcustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        Customer customer1= customerService.addCustomer(customer);
        return customer1;
    }

    @PutMapping("updatecustomer/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody  Customer customer) {
       return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("deletecustomer/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }


}

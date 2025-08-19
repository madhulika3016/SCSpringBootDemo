package com.controllers;

import com.model.Customer;
import com.service.CustomerService;
import com.service.CustomerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService1 customerService;

    @GetMapping("getcustomers")
    public List<Customer> getCustomers() {
      List<Customer> lc= customerService.getAllCustomers();
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

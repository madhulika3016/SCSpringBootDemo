package com.firstspringbootdemo.service;

import com.firstspringbootdemo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customers=new ArrayList<>();


    public Customer addCustomer(Customer customer) {
     customers.add(customer);
     return customer;
    }
    public List<Customer> getCustomers() {
     System.out.println(customers);
        return customers;
    }

    public Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null; // Not found
    }

    // Update
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer existing = customers.get(i);
            if (existing.getId() == id) {
                customers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }
        return null; // Not found
    }

    // Delete
    public boolean deleteCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
                return true;
            }
        }
        return false; // Not found
    }
}

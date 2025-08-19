package com.service;

import com.model.Customer;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService1 {

        @Autowired
         CustomerRepository repository;

        // Create
        public Customer addCustomer(Customer customer) {
            return repository.save(customer);
        }

        // Read all
        public List<Customer> getAllCustomers() {
            return repository.findAll();
        }

        // Read by ID
        public Customer getCustomerById(int id) {
            return repository.findById(id).orElse(null);
        }

        // Update
        public Customer updateCustomer(int id, Customer updatedCustomer) {
            Customer existing = repository.findById(id).orElse(null);
            if (existing != null) {
                existing.setEmail(updatedCustomer.getEmail());
                existing.setPhone(updatedCustomer.getPhone());
                existing.setActive(updatedCustomer.getActive());
                existing.setFirstname(updatedCustomer.getFirstname());
                existing.setLastname(updatedCustomer.getLastname());
                existing.setRole(updatedCustomer.getRole());
                return repository.save(existing);
            }
            return null;
        }

        // Delete
        public boolean deleteCustomer(int id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }
            return false;
        }
    }



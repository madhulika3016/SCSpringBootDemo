package com;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;
import com.service.CustomerService1;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    CustomerService1 customerservice;
    @MockitoBean
    public CustomerRepository repo;
    @Test
    void testGetCustomers() {
        Customer c1=new Customer();
        c1.setId(1);
        c1.setFirstname("Madhu");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password123");
        c1.setEmail("madhu@sc.com");
        c1.setPhone("678567856");
        c1.setActive("active");
        Customer c2=new Customer();
        c2.setId(2);
        c2.setFirstname("Madhulika");
        c2.setLastname("Dubey");
        c2.setRole("customer");
        c2.setPassword("password123");
        c2.setEmail("madhulika@sc.com");
        c2.setPhone("678567856");
        c2.setActive("active");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(c1);
        customerList.add(c2);

        Mockito.when(repo.findAll()).thenReturn(customerList);

        assertThat(customerservice.getAllCustomers()).isEqualTo(customerList);
    }

    @Test
   // @Disabled
    void testGetCustomerById() throws Throwable {

        Customer c1=new Customer();
        c1.setId(1);
        c1.setFirstname("Madhu");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password123");
        c1.setActive("active");
        c1.setPhone("678567856");
        c1.setEmail("madhu@sc.com");

        Optional<Customer> c2=Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);

        assertThat(customerservice.getCustomerById(1)).isEqualTo(c1);
    }

    @Test
    void testAddCustomer() {
        Customer c1=new Customer();
        c1.setId(1);
        c1.setFirstname("Madhu");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password123");
        c1.setActive("active");
        c1.setPhone("678567856");
        c1.setEmail("madhu@sc.com");
        Mockito.when(repo.save(c1)).thenReturn(c1);

        assertThat(customerservice.addCustomer(c1)).isEqualTo(c1);
    }

    @Test
    void testUpdateCustomer() throws Throwable {
        Customer c1=new Customer();
        c1.setId(1);
        c1.setFirstname("Madhu");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password123");
        c1.setActive("active");
        c1.setPhone("678567856");
        c1.setEmail("madhu@sc.com");
        Optional<Customer> c2=Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);

        c1.setFirstname("Madhulika");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password12");
        c1.setActive("active");
        c1.setPhone("678567856");
        c1.setEmail("madhulika@sc.com");
        Mockito.when(repo.save(c1)).thenReturn(c1);
        assertThat(customerservice.updateCustomer(c1.getId(), c1)).isEqualTo(c1);
    }

    @Test
    void testDeleteCustomer() {
        Customer c1=new Customer();
        c1.setId(1);
        c1.setFirstname("Madhu");
        c1.setLastname("Dubey");
        c1.setRole("customer");
        c1.setPassword("password123");
        c1.setActive("active");
        c1.setPhone("678567856");
        c1.setEmail("madhu@sc.com");
        Optional<Customer> c2=Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);
        Mockito.when(repo.existsById(c1.getId())).thenReturn(false);
        assertFalse(repo.existsById(c1.getId()));
    }
}

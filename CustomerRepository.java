package com.repository;

import com.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    Customer getCustomerByFirstname(String firstname);

    @Query("Select c from Customer c where c.role=?1 order by c.firstname")
    List<Customer> getCustomerByRoleSortedByFirstname(String role);
}

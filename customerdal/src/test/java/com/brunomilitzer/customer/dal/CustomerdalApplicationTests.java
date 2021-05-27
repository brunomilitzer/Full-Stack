package com.brunomilitzer.customer.dal;

import com.brunomilitzer.customer.dal.entities.*;
import com.brunomilitzer.customer.dal.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerdalApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testCreateCustomer() {

        Customer customer = new Customer();
        customer.setName("John");
        customer.setEmail("johndoe@hotmail.com");

        repository.save(customer);
    }

    @Test
    void testFindCustomerById() {

        Customer customer = repository.findById(1L).get();

        System.out.println(customer);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = repository.findById(1L).get();

        customer.setEmail("johndoe@gmail.com");

        repository.save(customer);
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = repository.findById(1L).get();

        repository.delete(customer);
    }

}

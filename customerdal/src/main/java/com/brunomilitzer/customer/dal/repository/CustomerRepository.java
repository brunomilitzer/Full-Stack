package com.brunomilitzer.customer.dal.repository;

import com.brunomilitzer.customer.dal.entities.*;
import org.springframework.data.repository.*;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

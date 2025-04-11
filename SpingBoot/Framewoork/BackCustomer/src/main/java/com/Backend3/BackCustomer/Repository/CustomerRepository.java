package com.Backend3.BackCustomer.Repository;

import com.Backend3.BackCustomer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

package com.Backend3.BackCustomer.Service;

import com.Backend3.BackCustomer.Model.Customer;

public interface CustomerService {

    Iterable<Customer> getList();
    Customer getCustomer(int id);
    void DeleteCustomer(int id);
    Customer UpdateCustomer(int id,Customer newCustomer);
    Customer CrearCustomer(Customer newCustomer);
    Customer StartWith(String nombre);
}

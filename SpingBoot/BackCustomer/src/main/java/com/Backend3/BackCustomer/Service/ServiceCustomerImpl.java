package com.Backend3.BackCustomer.Service;

import com.Backend3.BackCustomer.Exceptions.ResourceNotFoundExceptions;
import com.Backend3.BackCustomer.Model.Customer;
import com.Backend3.BackCustomer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCustomerImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    public Iterable<Customer> getList() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomer(int id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundExceptions());
    }

    @Override
    public void DeleteCustomer(int id) {
        repository.deleteById(id);
    }

    @Override
    public Customer UpdateCustomer(int id,Customer newCustomer) {
        Customer oldCustomer= repository.findById(id).orElseThrow(()->new ResourceNotFoundExceptions());
        oldCustomer.setNombre(newCustomer.getNombre());
        oldCustomer.setApellido(newCustomer.getApellido());
        oldCustomer.setEmail(newCustomer.getEmail());
        return repository.save(oldCustomer);
    }

    @Override
    public Customer CrearCustomer(Customer newCustomer) {
        return repository.save(newCustomer);
    }
}

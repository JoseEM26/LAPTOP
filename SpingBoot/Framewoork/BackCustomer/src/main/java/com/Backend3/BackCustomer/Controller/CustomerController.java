package com.Backend3.BackCustomer.Controller;

import com.Backend3.BackCustomer.Model.Customer;
import com.Backend3.BackCustomer.Service.ServiceCustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    ServiceCustomerImpl service;

    @GetMapping
    public Iterable<Customer> getList(){
        return service.getList();
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }
    @PostMapping
    public Customer PostCustomer(@RequestBody Customer customer){
        return  service.CrearCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer PutCustomer(@PathVariable int id,@RequestBody Customer customer){
        return  service.UpdateCustomer(id,customer);
    }
    @DeleteMapping("/{id}")
    public void DeleteCustomer(@PathVariable int id){
        service.DeleteCustomer(id);
    }
}

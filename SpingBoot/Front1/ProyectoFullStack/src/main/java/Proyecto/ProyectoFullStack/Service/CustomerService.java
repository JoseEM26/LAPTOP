package Proyecto.ProyectoFullStack.Service;

import Proyecto.ProyectoFullStack.Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> ListCustomer();
    Customer getCustomer(Long id);
    Customer add(Customer newCustomer);
    Customer update(Customer customer);
    void DeleteByID(Long id);

}

package Proyecto.ProyectoFullStack.Controller;

import Proyecto.ProyectoFullStack.Model.Customer;
import Proyecto.ProyectoFullStack.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerServiceImpl service;

    public CustomerController(CustomerServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Customer add(@RequestBody Customer customer){
        return service.add(customer);
    }

    @GetMapping
    public List<Customer> ListCustomer(){
        return service.ListCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return service.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteCustomer(@PathVariable Long id){
        service.DeleteByID(id);
    }

    @PutMapping
    public Customer UpdateCUstomer(@RequestBody Customer newCustomer){
        Customer oldCUstomer= service.getCustomer(newCustomer.getId());
        oldCUstomer.setFirstName(newCustomer.getFirstName());
        oldCUstomer.setEmail(newCustomer.getEmail());
        oldCUstomer.setLastName(newCustomer.getLastName());
        return service.update(newCustomer);
    }


}

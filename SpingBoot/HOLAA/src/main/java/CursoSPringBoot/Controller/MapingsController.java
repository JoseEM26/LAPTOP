package CursoSPringBoot.Controller;

import CursoSPringBoot.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MapingsController {

    private List<Customer> lista=new ArrayList<>(Arrays.asList(
            new Customer("Jose","Angel","joseangel1",111),
            new Customer("Espinoza","Morales","adfgadg",113),
            new Customer("Naydelin","Ivana","asdasd",112)
    ));



    @GetMapping({"/lista"})
    public List<Customer> get(){
        return lista;
    }

    @GetMapping("/lista/{cliente}")
    public Customer filtro(@PathVariable String cliente){
        Customer customer= lista.stream().filter(x->x.getNombre().equalsIgnoreCase(cliente))
                .findFirst().orElse(null);
        return  customer;
    }

    @PostMapping("/lista ")
    public Customer Post(@RequestBody Customer customer){

        lista.add(customer);

        return customer;
    }

    @PutMapping("/lista")
    public Customer Put(@RequestBody Customer customer){

        for(Customer x : lista){
            if(x.getId()==customer.getId()){
                x.setNombre(customer.getNombre());
                x.setApellido(customer.getApellido());
                x.setPassword(customer.getPassword());
                return  x;

            }
        }
 return null;
    }

    @DeleteMapping("/lista/{id}")
    public Customer Delete(@PathVariable int id){

        for(Customer x :lista){
            if(x.getId()==id){
                lista.remove(x);
                return  x;
            }
        }
        return  null;
    }

    @PatchMapping("lista")
    public Customer Patch(@RequestBody Customer customer){
        for(Customer c : lista){
            if(c.getId() == customer.getId()){

                if(customer.getNombre()!= null){
                    c.setNombre(customer.getNombre());
                }
                if(customer.getApellido()!= null){
                    c.setApellido(customer.getApellido());
                }
                if(customer.getPassword()!= null){
                    c.setPassword(customer.getPassword());
                }
                return  c;
            }
        }
        return  null;
    }




























}

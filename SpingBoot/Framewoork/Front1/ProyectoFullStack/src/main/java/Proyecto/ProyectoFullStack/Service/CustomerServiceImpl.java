    package Proyecto.ProyectoFullStack.Service;

    import Proyecto.ProyectoFullStack.Exceptions.ResourceNotFoundException;
    import Proyecto.ProyectoFullStack.Model.Customer;
    import Proyecto.ProyectoFullStack.Repository.CustomerRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class CustomerServiceImpl implements CustomerService{

        @Autowired
        CustomerRepository customerRepository;

        public CustomerServiceImpl(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        @Override
        public List<Customer> ListCustomer() {
            return customerRepository.findAll();
        }

        @Override
        public Customer getCustomer(Long id) {
            return customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el Customer con ID en Get: " + id));
        }



        @Override
        public Customer add(Customer newCustomer) {
            return customerRepository.save(newCustomer);
        }

        @Override
        public Customer update(Customer customer) {
            if (customer.getId() == null) {
                throw new ResourceNotFoundException("El ID del Customer en Put no puede ser nulo.");
            }

            customerRepository.findById(customer.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el Customer con ID: " + customer.getId()));

            return customerRepository.save(customer);
        }


        @Override
        public void DeleteByID(Long id) {
            customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el Customer con ID en el Delete: " + id));

            customerRepository.deleteById(id);
        }
    }

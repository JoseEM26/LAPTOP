package Proyecto.ProyectoFullStack.Repository;

import Proyecto.ProyectoFullStack.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

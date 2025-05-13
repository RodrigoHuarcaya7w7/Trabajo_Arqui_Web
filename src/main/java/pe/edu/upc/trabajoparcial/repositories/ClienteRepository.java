package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
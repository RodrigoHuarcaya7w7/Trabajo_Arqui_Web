package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}
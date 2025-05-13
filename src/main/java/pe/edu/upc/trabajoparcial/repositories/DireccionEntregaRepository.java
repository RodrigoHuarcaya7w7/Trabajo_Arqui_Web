package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Cliente;
import pe.edu.upc.trabajoparcial.entities.DireccionEntrega;


import java.util.List;

@Repository
public interface DireccionEntregaRepository extends JpaRepository<DireccionEntrega, Integer> {


    List<DireccionEntrega> findByClienteIdCliente(Integer idCliente);
}
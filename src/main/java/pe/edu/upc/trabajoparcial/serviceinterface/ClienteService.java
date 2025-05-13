package pe.edu.upc.trabajoparcial.serviceinterface;


import pe.edu.upc.trabajoparcial.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente save(Cliente cliente);

    void deleteById(Integer id);
}
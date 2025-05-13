package pe.edu.upc.trabajoparcial.serviceinterface;


import pe.edu.upc.trabajoparcial.entities.DireccionEntrega;

import java.util.List;
import java.util.Optional;

public interface DireccionEntregaService {

    List<DireccionEntrega> findAll();

    Optional<DireccionEntrega> findById(Integer id);

    DireccionEntrega save(DireccionEntrega direccionEntrega);

    void deleteById(Integer id);
}
package pe.edu.upc.trabajoparcial.serviceinterface;

import pe.edu.upc.trabajoparcial.entities.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {

    List<MetodoPago> findAll();

    Optional<MetodoPago> findById(Integer id);

    MetodoPago save(MetodoPago metodoPago);

    void deleteById(Integer id);
}
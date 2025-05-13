package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.TipoPago;

import java.util.List;
import java.util.Optional;

public interface TipoPagoService {

    List<TipoPago> findAll();

    Optional<TipoPago> findById(Integer id);

    TipoPago save(TipoPago tipoPago);

    void deleteById(Integer id);
}
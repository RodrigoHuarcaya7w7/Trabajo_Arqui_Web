package pe.edu.upc.trabajoparcial.serviceinterface;

import pe.edu.upc.trabajoparcial.entities.OfertaTipoProducto;

import java.util.List;
import java.util.Optional;

public interface OfertaTipoProductoService {

    List<OfertaTipoProducto> findAll();

    Optional<OfertaTipoProducto> findById(Integer id);

    OfertaTipoProducto save(OfertaTipoProducto ofertaTipoProducto);

    void deleteById(Integer id);
}
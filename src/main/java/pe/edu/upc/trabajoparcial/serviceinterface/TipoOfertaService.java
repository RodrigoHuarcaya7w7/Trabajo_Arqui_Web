package pe.edu.upc.trabajoparcial.serviceinterface;


import pe.edu.upc.trabajoparcial.entities.TipoOferta;

import java.util.List;
import java.util.Optional;

public interface TipoOfertaService {

    List<TipoOferta> findAll();

    Optional<TipoOferta> findById(Integer id);

    TipoOferta save(TipoOferta tipoOferta);

    void deleteById(Integer id);
}
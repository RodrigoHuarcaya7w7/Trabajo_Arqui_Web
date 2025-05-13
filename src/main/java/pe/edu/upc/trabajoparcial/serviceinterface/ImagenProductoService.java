package pe.edu.upc.trabajoparcial.serviceinterface;


import pe.edu.upc.trabajoparcial.entities.ImagenProducto;

import java.util.List;
import java.util.Optional;

public interface ImagenProductoService {

    List<ImagenProducto> findAll();

    Optional<ImagenProducto> findById(Integer id);

    ImagenProducto save(ImagenProducto imagenProducto);

    void deleteById(Integer id);
}
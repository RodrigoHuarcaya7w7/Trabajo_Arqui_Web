package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.Producto;


import java.util.List;


@Repository
public interface ImagenProductoRepository extends JpaRepository<ImagenProducto, Integer> {

}
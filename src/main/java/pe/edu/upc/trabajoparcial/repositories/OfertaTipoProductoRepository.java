package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.MetodoPago;
import pe.edu.upc.trabajoparcial.entities.OfertaTipoProducto;

import java.util.List;

@Repository
public interface OfertaTipoProductoRepository extends JpaRepository<OfertaTipoProducto, Integer> {

    // Buscar ofertas de un producto
    List<OfertaTipoProducto> findByProductoIdProducto(Integer idProducto);
}
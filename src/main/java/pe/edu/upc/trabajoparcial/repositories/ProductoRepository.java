package pe.edu.upc.trabajoparcial.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Producto;


import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaNombreContainingIgnoreCase(String categoria);

    // **CORRECCIÓN**: usar "Between"
    List<Producto> findByPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio);

    List<Producto> findByClienteIdCliente(Integer idCliente);



    /**
     * Devuelve los productos ordenados por precio DESC, limitado por Pageable.
     */
    List<Producto> findAllByOrderByPrecioDesc(Pageable pageable);

}
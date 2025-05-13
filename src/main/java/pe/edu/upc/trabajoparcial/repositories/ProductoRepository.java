package pe.edu.upc.trabajoparcial.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Producto;


import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Buscar productos por nombre
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Buscar productos por categoría
    List<Producto> findByCategoriaNombreContainingIgnoreCase(String categoria);

    // Buscar productos por rango de precio
    List<Producto> findByPrecioBetween(Float minPrecio, Float maxPrecio);

    // Buscar productos de un vendedor
    List<Producto> findByClienteIdCliente(Integer idCliente);
}
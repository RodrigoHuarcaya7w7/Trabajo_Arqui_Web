package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Integer id);

    Producto save(Producto producto);

    void deleteById(Integer id);

    List<Producto> findByNombre(String nombre);

    List<Producto> findByCategoria(String categoria);

    List<Producto> findByPrecioRange(Float minPrecio, Float maxPrecio);

    List<Producto> findByVendedor(Integer idCliente);
}
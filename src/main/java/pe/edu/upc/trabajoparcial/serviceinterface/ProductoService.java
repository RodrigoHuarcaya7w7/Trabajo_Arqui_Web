package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoService {


    List<Producto> findAll();
    Optional<Producto> findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);


    List<Producto> findByNombre(String nombre);

    List<Producto> findByCategoria(String categoria);

    // **Usamos el mismo nombre Between para que coincida con el repo**
    List<Producto> findByPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio);

    List<Producto> findByVendedor(Integer idCliente);

    /**
     * @param topN cuántos productos devolver
     * @return lista de los N productos con mayor precio
     */
    List<Producto> topNProductosMasCaros(int topN);
}
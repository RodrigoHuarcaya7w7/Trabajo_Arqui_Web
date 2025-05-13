package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.MetodoPago;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;

import java.util.List;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica, Integer> {

    // Obtener métricas de un vendedor (cliente) específico
    List<Metrica> findByClienteIdCliente(Integer idCliente);

    // Promedio de ventas totales por producto
    @Query("SELECT AVG(m.ventasTotales) FROM Metrica m WHERE m.producto.idProducto = :idProducto")
    Float findPromedioVentasPorProducto(Integer idProducto);

    // Obtener productos con el mejor rendimiento (ordenados por ventas totales)
    @Query("SELECT m.producto FROM Metrica m ORDER BY m.ventasTotales DESC")
    List<Producto> findProductosConMejorRendimiento();
}
package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.MetodoPago;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica, Integer> {

    @Query("""
      SELECT p, COALESCE(SUM(m.ventasTotales),0)
      FROM Producto p
      LEFT JOIN Metrica m ON m.producto = p
      GROUP BY p
      ORDER BY COALESCE(SUM(m.ventasTotales),0) DESC
    """)
    List<Object[]> topNProductosPorMonto(Pageable pageable);

    /**
     * Top N productos por unidades vendidas.
     * Incluye todos los productos (sin métricas = 0).
     */
    @Query("""
      SELECT p, COALESCE(SUM(m.productosVendidos),0)
      FROM Producto p
      LEFT JOIN Metrica m ON m.producto = p
      GROUP BY p
      ORDER BY COALESCE(SUM(m.productosVendidos),0) DESC
    """)
    List<Object[]> topNProductosPorUnidades(Pageable pageable);

    @Query("""
      SELECT dp.producto,
             COALESCE(SUM(dp.cantidad), 0),
             COALESCE(SUM(dp.cantidad * dp.producto.precio), 0),
             MAX(dp.pedido.fecha)
      FROM DetallePedido dp
      WHERE dp.pedido.estado = 'PAGADO'
      GROUP BY dp.producto
      ORDER BY SUM(dp.cantidad * dp.producto.precio) DESC
    """)
    List<Object[]> fetchMetrics(Pageable pageable);

    /**
     * Top N categorías por ingresos (cantidad·precio), sólo pedidos PAGADO.
     * Devuelve pares [nombreCategoria, totalIngresos].
     */
    @Query("""
      SELECT dp.producto.categoria.nombre, 
             COALESCE(SUM(dp.cantidad * dp.producto.precio), 0)
      FROM DetallePedido dp
      WHERE dp.pedido.estado = 'PAGADO'
      GROUP BY dp.producto.categoria.nombre
      ORDER BY SUM(dp.cantidad * dp.producto.precio) DESC
    """)
    List<Object[]> topNCategoriasPorMonto(Pageable pageable);
}

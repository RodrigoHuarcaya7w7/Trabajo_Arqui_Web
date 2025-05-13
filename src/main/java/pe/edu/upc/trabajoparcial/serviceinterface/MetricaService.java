package pe.edu.upc.trabajoparcial.serviceinterface;

import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;

import java.util.List;

public interface MetricaService {

    // Buscar todas las métricas
    List<Metrica> findAll();

    // Buscar métricas por cliente
    List<Metrica> findByCliente(Integer idCliente);

    // Promedio de ventas por producto
    Float findPromedioVentasPorProducto(Integer idProducto);

    // Obtener productos con mejor rendimiento
    List<Producto> findProductosConMejorRendimiento();

    // Guardar una nueva métrica
    Metrica save(Metrica metrica);

    // Eliminar una métrica por id
    void deleteById(Integer id);
}
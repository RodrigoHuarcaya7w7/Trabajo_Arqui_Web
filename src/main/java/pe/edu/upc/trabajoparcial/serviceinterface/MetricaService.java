package pe.edu.upc.trabajoparcial.serviceinterface;

import pe.edu.upc.trabajoparcial.DTOs.MetricaDTO;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;

import java.util.List;

public interface MetricaService {

    // Buscar todas las métricas
    List<Metrica> findAll();




    List<MetricaDTO> getDynamicMetrics(int topN);

    /**
     * Devuelve las N categorías que más ingresos han generado.
     * @param topN número de categorías a devolver
     * @return lista de pares [nombreCategoria, totalIngresos]
     */
    List<Object[]> topNCategoriasPorMonto(int topN);

    List<Object[]> topNProductosPorUnidades(int topN);

}
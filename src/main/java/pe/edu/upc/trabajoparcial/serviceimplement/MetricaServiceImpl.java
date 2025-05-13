package pe.edu.upc.trabajoparcial.serviceimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.repositories.MetricaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.MetricaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricaServiceImpl implements MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    @Override
    public List<Metrica> findAll() {
        return metricaRepository.findAll();
    }

    @Override
    public List<Metrica> findByCliente(Integer idCliente) {
        return metricaRepository.findByClienteIdCliente(idCliente);  // Consultar métricas por cliente
    }

    @Override
    public Float findPromedioVentasPorProducto(Integer idProducto) {
        return metricaRepository.findPromedioVentasPorProducto(idProducto);  // Calcular promedio de ventas
    }

    @Override
    public List<Producto> findProductosConMejorRendimiento() {
        return metricaRepository.findProductosConMejorRendimiento();  // Consultar productos con mejor rendimiento
    }

    @Override
    public Metrica save(Metrica metrica) {
        return metricaRepository.save(metrica);  // Guardar una métrica
    }

    @Override
    public void deleteById(Integer id) {
        metricaRepository.deleteById(id);  // Eliminar una métrica por id
    }
}
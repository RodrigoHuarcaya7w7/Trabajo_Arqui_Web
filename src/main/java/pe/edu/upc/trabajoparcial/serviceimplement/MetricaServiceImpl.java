package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.DTOs.MetricaDTO;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.repositories.MetricaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.MetricaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetricaServiceImpl implements MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    @Override
    public List<Metrica> findAll() {
        return metricaRepository.findAll();
    }


    @Override
    public List<Object[]> topNProductosPorUnidades(int topN) {
        return metricaRepository
                .topNProductosPorUnidades(PageRequest.of(0, topN));
    }

    @Override
    public List<MetricaDTO> getDynamicMetrics(int topN) {
        return metricaRepository.fetchMetrics(PageRequest.of(0, topN))
                .stream()
                .map(row -> {
                    var producto       = (pe.edu.upc.trabajoparcial.entities.Producto) row[0];
                    Integer unidades   = ((Number) row[1]).intValue();
                    Double monto       = ((Number) row[2]).doubleValue();
                    LocalDateTime fecha= (LocalDateTime) row[3];
                    return new MetricaDTO(
                            producto.getIdProducto(),
                            producto.getNombre(),
                            producto.getCategoria().getNombre(),
                            unidades,
                            monto,
                            fecha
                    );
                })
                .collect(Collectors.toList());
    }
    @Override
    public List<Object[]> topNCategoriasPorMonto(int topN) {
        // Creamos PageRequest para limitar a topN
        return metricaRepository.topNCategoriasPorMonto(PageRequest.of(0, topN));
    }

}
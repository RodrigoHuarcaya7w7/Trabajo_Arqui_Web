package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.DTOs.MetricaDTO;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.repositories.MetricaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.MetricaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/metricas")
public class MetricaController {

    @Autowired
    private MetricaService metricaService;



    // Obtener todas las métricas
    @GetMapping
    public List<Metrica> getAllMetricas() {
        return metricaService.findAll();
    }



    @GetMapping("/top-productos/por-unidades/{n}")
    public ResponseEntity<List<Map<String,Object>>> topPorUnidades(@PathVariable int n) {
        List<Object[]> rows = metricaService.topNProductosPorUnidades(n);
        List<Map<String,Object>> resp = rows.stream()
                .map(r -> {
                    Producto p        = (Producto) r[0];
                    int unidades      = ((Number) r[1]).intValue();
                    return Map.<String,Object>of(
                            "productoId",      p.getIdProducto(),
                            "nombre",          p.getNombre(),
                            "categoria",       p.getCategoria().getNombre(),
                            "unidadesVendidas", unidades
                    );
                })
                .toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping ("/top-productosT")
    public ResponseEntity<List<MetricaDTO>> getMetrics(
            @RequestParam(name="topN", defaultValue="10") int topN) {
        List<MetricaDTO> dtos = metricaService.getDynamicMetrics(topN);
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/top-categorias/por-monto/{n}")
    public ResponseEntity<List<Map<String,Object>>> topCategoriasPorMonto(
            @PathVariable("n") int n) {
        List<Object[]> rows = metricaService.topNCategoriasPorMonto(n);
        List<Map<String,Object>> resp = rows.stream()
                .map(r -> Map.<String,Object>of(
                        "categoria",    r[0],
                        "totalIngresos", ((Number) r[1]).doubleValue()
                ))
                .toList();
        return ResponseEntity.ok(resp);
    }
}
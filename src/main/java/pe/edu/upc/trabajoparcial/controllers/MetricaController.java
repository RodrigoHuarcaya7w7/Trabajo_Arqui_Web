package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.Metrica;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.repositories.MetricaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.MetricaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    // Obtener métricas por cliente
    @GetMapping("/cliente/{idCliente}")
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    public ResponseEntity<List<Metrica>> getMetricasByCliente(@PathVariable Integer idCliente) {
        List<Metrica> metricas = metricaService.findByCliente(idCliente);
        if (metricas.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si no se encuentran métricas, respondemos con 404
        }
        return ResponseEntity.ok(metricas);  // Si hay métricas, las devolvemos
    }

    // Obtener el promedio de ventas por producto
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    @GetMapping("/promedio-ventas/{idProducto}")
    public ResponseEntity<Float> getPromedioVentasPorProducto(@PathVariable Integer idProducto) {
        Float promedioVentas = metricaService.findPromedioVentasPorProducto(idProducto);
        if (promedioVentas == null) {
            return ResponseEntity.notFound().build();  // Si no se encuentra el promedio, respondemos con 404
        }
        return ResponseEntity.ok(promedioVentas);  // Si hay resultado, lo devolvemos
    }

    // Obtener productos con el mejor rendimiento
    @GetMapping("/productos-mejor-rendimiento")
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    public ResponseEntity<List<Producto>> getProductosConMejorRendimiento() {
        List<Producto> productos = metricaService.findProductosConMejorRendimiento();
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si no hay productos, respondemos con 404
        }
        return ResponseEntity.ok(productos);  // Devolvemos la lista de productos
    }

    // Crear una nueva métrica
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    public ResponseEntity<Metrica> createMetrica(@RequestBody Metrica metrica) {
        Metrica createdMetrica = metricaService.save(metrica);
        return ResponseEntity.ok(createdMetrica);
    }

    // Actualizar una métrica
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    public ResponseEntity<Metrica> updateMetrica(@PathVariable Integer id, @RequestBody Metrica metrica) {
        metrica.setIdMetrica(id);
        Metrica updatedMetrica = metricaService.save(metrica);
        return ResponseEntity.ok(updatedMetrica);
    }

    // Eliminar una métrica
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_VENDEDOR')")
    public ResponseEntity<Void> deleteMetrica(@PathVariable Integer id) {
        metricaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
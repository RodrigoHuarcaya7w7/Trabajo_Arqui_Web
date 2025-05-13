package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.DetallePedido;
import pe.edu.upc.trabajoparcial.serviceinterface.DetallePedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle-pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Integer id) {
        Optional<DetallePedido> detallePedido = detallePedidoService.findById(id);
        return detallePedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetallePedido> createDetallePedido(@RequestBody DetallePedido detallePedido) {
        DetallePedido createdDetallePedido = detallePedidoService.save(detallePedido);
        return ResponseEntity.ok(createdDetallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        detallePedido.setIdDetalle(id);
        DetallePedido updatedDetallePedido = detallePedidoService.save(detallePedido);
        return ResponseEntity.ok(updatedDetallePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
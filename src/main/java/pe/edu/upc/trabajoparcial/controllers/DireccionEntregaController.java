package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.DireccionEntrega;
import pe.edu.upc.trabajoparcial.serviceinterface.DireccionEntregaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/direccion-entregas")
public class DireccionEntregaController {

    @Autowired
    private DireccionEntregaService direccionEntregaService;

    @GetMapping
    public List<DireccionEntrega> getAllDireccionEntregas() {
        return direccionEntregaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionEntrega> getDireccionEntregaById(@PathVariable Integer id) {
        Optional<DireccionEntrega> direccionEntrega = direccionEntregaService.findById(id);
        return direccionEntrega.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DireccionEntrega> createDireccionEntrega(@RequestBody DireccionEntrega direccionEntrega) {
        DireccionEntrega createdDireccionEntrega = direccionEntregaService.save(direccionEntrega);
        return ResponseEntity.ok(createdDireccionEntrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionEntrega> updateDireccionEntrega(@PathVariable Integer id, @RequestBody DireccionEntrega direccionEntrega) {
        direccionEntrega.setIdDireccion(id);
        DireccionEntrega updatedDireccionEntrega = direccionEntregaService.save(direccionEntrega);
        return ResponseEntity.ok(updatedDireccionEntrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccionEntrega(@PathVariable Integer id) {
        direccionEntregaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
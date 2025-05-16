package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public List<DireccionEntrega> getAllDireccionEntregas() {
        return direccionEntregaService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<DireccionEntrega> getDireccionEntregaById(@PathVariable Integer id) {
        Optional<DireccionEntrega> direccionEntrega = direccionEntregaService.findById(id);
        return direccionEntrega.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<DireccionEntrega> createDireccionEntrega(@RequestBody DireccionEntrega direccionEntrega) {
        DireccionEntrega createdDireccionEntrega = direccionEntregaService.save(direccionEntrega);
        return ResponseEntity.ok(createdDireccionEntrega);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<DireccionEntrega> updateDireccionEntrega(@PathVariable Integer id, @RequestBody DireccionEntrega direccionEntrega) {
        direccionEntrega.setIdDireccion(id);
        DireccionEntrega updatedDireccionEntrega = direccionEntregaService.save(direccionEntrega);
        return ResponseEntity.ok(updatedDireccionEntrega);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Void> deleteDireccionEntrega(@PathVariable Integer id) {
        direccionEntregaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.OfertaTipoProducto;
import pe.edu.upc.trabajoparcial.serviceinterface.OfertaTipoProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas-tipo-productos")
public class OfertaTipoProductoController {



    @Autowired
    private OfertaTipoProductoService ofertaTipoProductoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public List<OfertaTipoProducto> getAllOfertasTipoProductos() {
        return ofertaTipoProductoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<OfertaTipoProducto> getOfertaTipoProductoById(@PathVariable Integer id) {
        Optional<OfertaTipoProducto> ofertaTipoProducto = ofertaTipoProductoService.findById(id);
        return ofertaTipoProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<OfertaTipoProducto> createOfertaTipoProducto(@RequestBody OfertaTipoProducto ofertaTipoProducto) {
        OfertaTipoProducto createdOfertaTipoProducto = ofertaTipoProductoService.save(ofertaTipoProducto);
        return ResponseEntity.ok(createdOfertaTipoProducto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<OfertaTipoProducto> updateOfertaTipoProducto(@PathVariable Integer id, @RequestBody OfertaTipoProducto ofertaTipoProducto) {
        ofertaTipoProducto.setId(id);
        OfertaTipoProducto updatedOfertaTipoProducto = ofertaTipoProductoService.save(ofertaTipoProducto);
        return ResponseEntity.ok(updatedOfertaTipoProducto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteOfertaTipoProducto(@PathVariable Integer id) {
        ofertaTipoProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
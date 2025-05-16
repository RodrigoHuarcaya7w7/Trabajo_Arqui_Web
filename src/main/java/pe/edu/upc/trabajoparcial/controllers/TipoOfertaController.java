package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.TipoOferta;
import pe.edu.upc.trabajoparcial.serviceinterface.TipoOfertaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoofertas")
public class TipoOfertaController {


    @Autowired
    private TipoOfertaService tipoOfertaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public List<TipoOferta> getAllTipoOfertas() {
        return tipoOfertaService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<TipoOferta> getTipoOfertaById(@PathVariable Integer id) {
        Optional<TipoOferta> tipoOferta = tipoOfertaService.findById(id);
        return tipoOferta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<TipoOferta> createTipoOferta(@RequestBody TipoOferta tipoOferta) {
        TipoOferta createdTipoOferta = tipoOfertaService.save(tipoOferta);
        return ResponseEntity.ok(createdTipoOferta);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<TipoOferta> updateTipoOferta(@PathVariable Integer id, @RequestBody TipoOferta tipoOferta) {
        tipoOferta.setIdTipoOferta(id);
        TipoOferta updatedTipoOferta = tipoOfertaService.save(tipoOferta);
        return ResponseEntity.ok(updatedTipoOferta);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteTipoOferta(@PathVariable Integer id) {
        tipoOfertaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
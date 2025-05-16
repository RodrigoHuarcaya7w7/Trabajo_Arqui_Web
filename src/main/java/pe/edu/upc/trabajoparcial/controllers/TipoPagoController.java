package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.TipoPago;
import pe.edu.upc.trabajoparcial.serviceinterface.TipoPagoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-pagos")
public class TipoPagoController {



    @Autowired
    private TipoPagoService tipoPagoService;

    @GetMapping
    public List<TipoPago> getAllTipoPagos() {
        return tipoPagoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable Integer id) {
        Optional<TipoPago> tipoPago = tipoPagoService.findById(id);
        return tipoPago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> createTipoPago(@RequestBody TipoPago tipoPago) {
        List<String> permitidos = List.of("Qr", "Tarjeta");

        if (!permitidos.contains(tipoPago.getNombrePago())) {
            return ResponseEntity
                    .badRequest()
                    .body("⚠️ Tipo de pago no válido. Solo se permite: Qr, Tarjeta");
        }

        TipoPago createdTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.ok(createdTipoPago);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<TipoPago> updateTipoPago(@PathVariable Integer id, @RequestBody TipoPago tipoPago) {
        tipoPago.setIdTipoPago(id);
        TipoPago updatedTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.ok(updatedTipoPago);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Integer id) {
        tipoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
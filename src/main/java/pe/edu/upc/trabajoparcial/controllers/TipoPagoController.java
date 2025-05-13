package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable Integer id) {
        Optional<TipoPago> tipoPago = tipoPagoService.findById(id);
        return tipoPago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPago> createTipoPago(@RequestBody TipoPago tipoPago) {
        TipoPago createdTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.ok(createdTipoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> updateTipoPago(@PathVariable Integer id, @RequestBody TipoPago tipoPago) {
        tipoPago.setIdTipoPago(id);
        TipoPago updatedTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.ok(updatedTipoPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Integer id) {
        tipoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
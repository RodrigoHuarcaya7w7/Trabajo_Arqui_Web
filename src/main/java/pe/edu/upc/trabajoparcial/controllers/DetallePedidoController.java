package pe.edu.upc.trabajoparcial.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.DetallePedido;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.security.UserSecurity;
import pe.edu.upc.trabajoparcial.serviceinterface.DetallePedidoService;
import org.springframework.security.core.Authentication;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle-pedidos")
public class DetallePedidoController {



    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Integer id) {
        Optional<DetallePedido> detallePedido = detallePedidoService.findById(id);
        return detallePedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<DetallePedido> createDetallePedido(@RequestBody DetallePedido detallePedido) {
        DetallePedido createdDetallePedido = detallePedidoService.save(detallePedido);
        return ResponseEntity.ok(createdDetallePedido);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        detallePedido.setIdDetalle(id);
        DetallePedido updatedDetallePedido = detallePedidoService.save(detallePedido);
        return ResponseEntity.ok(updatedDetallePedido);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mios")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<DetallePedido>> getMisDetalles(Authentication authentication) {
        Users user = ((UserSecurity) authentication.getPrincipal()).getUser();
        List<DetallePedido> misPedidos = detallePedidoService.findAllByUserId(user.getId());
        return ResponseEntity.ok(misPedidos);
    }

}
package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.serviceinterface.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {



    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto createdProducto = productoService.save(producto);
        return ResponseEntity.ok(createdProducto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        Producto updatedProducto = productoService.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.serviceinterface.ImagenProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagenes-producto")
public class ImagenProductoController {

    @Autowired
    private ImagenProductoService imagenProductoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public List<ImagenProducto> getAllImagenesProducto() {
        return imagenProductoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<ImagenProducto> getImagenProductoById(@PathVariable Integer id) {
        Optional<ImagenProducto> imagenProducto = imagenProductoService.findById(id);
        return imagenProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<ImagenProducto> createImagenProducto(@RequestBody ImagenProducto imagenProducto) {
        ImagenProducto createdImagenProducto = imagenProductoService.save(imagenProducto);
        return ResponseEntity.ok(createdImagenProducto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<ImagenProducto> updateImagenProducto(@PathVariable Integer id, @RequestBody ImagenProducto imagenProducto) {
        imagenProducto.setIdImagenProducto(id);
        ImagenProducto updatedImagenProducto = imagenProductoService.save(imagenProducto);
        return ResponseEntity.ok(updatedImagenProducto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Void> deleteImagenProducto(@PathVariable Integer id) {
        imagenProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.Categoria;
import pe.edu.upc.trabajoparcial.serviceinterface.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria createdCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok(createdCategoria);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        Categoria updatedCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
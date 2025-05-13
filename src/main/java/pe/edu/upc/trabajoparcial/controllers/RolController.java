package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.Role;
import pe.edu.upc.trabajoparcial.serviceinterface.RolService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Role> getAllRoles() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRolById(@PathVariable Integer id) {
        Optional<Role> rol = rolService.findById(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> createRol(@RequestBody Role rol) {
        Role createdRol = rolService.save(rol);
        return ResponseEntity.ok(createdRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRol(@PathVariable Integer id, @RequestBody Role rol) {
        rol.setId(Long.valueOf(id));
        Role updatedRol = rolService.save(rol);
        return ResponseEntity.ok(updatedRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.edu.upc.trabajoparcial.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.entities.Categoria;
import pe.edu.upc.trabajoparcial.entities.Cliente;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.entities.TipoOferta;
import pe.edu.upc.trabajoparcial.repositories.CategoriaRepository;
import pe.edu.upc.trabajoparcial.repositories.ClienteRepository;
import pe.edu.upc.trabajoparcial.repositories.TipoOfertaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired private ProductoService productoService;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private CategoriaRepository categoriaRepo;
    @Autowired private TipoOfertaRepository tipoOfertaRepo;



    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
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
    public ResponseEntity<Producto> createProducto(@RequestBody Producto p) {
        // forzar identidad nueva
        p.setIdProducto(null);

        // recargar las entidades relacionadas
        Cliente cliente = clienteRepo.findById(p.getCliente().getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        Categoria categoria = categoriaRepo.findById(p.getCategoria().getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));

        p.setCliente(cliente);
        p.setCategoria(categoria);

        if (p.getTipoOferta() != null && p.getTipoOferta().getIdTipoOferta() != null) {
            TipoOferta oferta = tipoOfertaRepo.findById(p.getTipoOferta().getIdTipoOferta())
                    .orElseThrow(() -> new EntityNotFoundException("Oferta no encontrada"));
            p.setTipoOferta(oferta);
        } else {
            p.setTipoOferta(null);
        }

        Producto creado = productoService.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
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
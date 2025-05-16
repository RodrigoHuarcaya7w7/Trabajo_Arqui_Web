package pe.edu.upc.trabajoparcial.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.DTOs.ClienteDTO;
import pe.edu.upc.trabajoparcial.entities.Cliente;
import pe.edu.upc.trabajoparcial.serviceinterface.ClienteService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

   /* @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }*/

    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public List<ClienteDTO> listar() {
        return clienteService.findAll().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ClienteDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.save(cliente);
        return ResponseEntity.ok(createdCliente);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        Cliente updatedCliente = clienteService.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

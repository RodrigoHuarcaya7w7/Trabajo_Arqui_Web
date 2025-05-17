package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.DTOs.DTOToken;
import pe.edu.upc.trabajoparcial.entities.DetallePedido;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.security.JwtUtilService;
import pe.edu.upc.trabajoparcial.security.UserSecurity;
import pe.edu.upc.trabajoparcial.serviceinterface.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;


    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN' )")
    public List<Users> getAllDetallePedidos() {
        return userService.findAll();
    }


@PostMapping("/users/comprador")
@PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
public ResponseEntity<Users> insertarComprador(@RequestBody Users user) {
    return new ResponseEntity<>(userService.addUserWithRole(user, "USER"), HttpStatus.CREATED);
}

@PostMapping("/users/vendedor")
@PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
public ResponseEntity<Users> insertarVendedor(@RequestBody Users user) {
    return new ResponseEntity<>(userService.addUserWithRole(user, "VENDEDOR"), HttpStatus.CREATED);
}

@PostMapping("/users/admin")
@PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR')")
public ResponseEntity<Users> insertarAdmin(@RequestBody Users user) {
    return new ResponseEntity<>(userService.addUserWithRole(user, "ADMIN"), HttpStatus.CREATED);
}



/*
    @PostMapping("/users")
    public ResponseEntity<Users> insertarUser(@RequestBody Users user) {
        Users newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }*/

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        System.out.println("🔥 Se llamó al método login");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (Exception e) {
            System.out.println("❌ Error de autenticación: " + e.getMessage());
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }

        UserSecurity userSecurity = (UserSecurity) userDetailsService.loadUserByUsername(user.getUsername());

        String jwt = jwtUtilService.generateToken(userSecurity);
        Long id = userSecurity.getUser().getId();
        String authorities = userSecurity.getUser().getRoles()
                .stream()
                .map(role -> role.getRol())
                .collect(Collectors.joining(";", "", ""));

        return new ResponseEntity<>(new DTOToken(jwt, id, authorities), HttpStatus.OK);



    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

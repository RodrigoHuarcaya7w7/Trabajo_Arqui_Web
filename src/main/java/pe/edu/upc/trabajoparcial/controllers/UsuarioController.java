package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoparcial.DTOs.DTOToken;
import pe.edu.upc.trabajoparcial.DTOs.UsuarioDTO;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.security.JwtUtilService;
import pe.edu.upc.trabajoparcial.security.UserSecurity;
import pe.edu.upc.trabajoparcial.serviceinterface.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;

    @PostMapping("/users")
    public ResponseEntity<Users> insertarUser(@RequestBody Users user) {
        Users newUser =userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("users/login")
    public ResponseEntity<DTOToken> login(@RequestBody Users user) {

        // Autenticación del usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // Obtener detalles del usuario desde el UserDetailsService
        UserSecurity userSecurity = (UserSecurity) userDetailsService.loadUserByUsername(user.getUsername());

        // Generar el JWT
        String jwt = jwtUtilService.generateToken(userSecurity);

        // Obtener ID del usuario
        Long id = userSecurity.getUser().getId();

        // Obtener las autoridades (roles) del usuario y unirlas en un String
        String authorities = userSecurity.getUser().getRoles()
                .stream()
                .map(role -> role.getRol())  // Mapear cada rol al nombre del rol
                .collect(Collectors.joining(";", "", ""));  // Concatenar los roles con un separador

        // Retornar el token JWT, ID de usuario y las autoridades
        return new ResponseEntity<>(new DTOToken(jwt, id, authorities), HttpStatus.OK);
    }

}
package pe.edu.upc.trabajoparcial.controllers;

import pe.edu.upc.trabajoparcial.DTOs.DTOToken;
import pe.edu.upc.trabajoparcial.security.JwtUtilService;
import pe.edu.upc.trabajoparcial.security.UserSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserSecurity userSecurity) {
        try {
            // Autenticamos al usuario con su username y password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userSecurity.getUsername(),
                            userSecurity.getPassword()
                    )
            );

            // Generamos el token usando el UserDetails completo
            String jwt = jwtUtilService.generateToken(userSecurity);

            return ResponseEntity.ok(new DTOToken(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}

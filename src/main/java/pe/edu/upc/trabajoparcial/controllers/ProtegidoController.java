package pe.edu.upc.trabajoparcial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protegido")
public class ProtegidoController {

    @GetMapping("/ejemplo")
    public String rutaProtegida() {
        return "✅ Acceso permitido: estás autenticado con JWT";
    }
}

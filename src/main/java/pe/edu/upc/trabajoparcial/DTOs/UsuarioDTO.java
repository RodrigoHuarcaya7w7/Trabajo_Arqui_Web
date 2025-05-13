package pe.edu.upc.trabajoparcial.DTOs;



import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String correo;

    // Constructor, getters y setters si es necesario
}
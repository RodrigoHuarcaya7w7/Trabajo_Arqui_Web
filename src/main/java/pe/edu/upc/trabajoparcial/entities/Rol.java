package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String nombreRol;
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

}

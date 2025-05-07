package pe.edu.upc.trabajoparcial.entities;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

// ---------- ENTIDAD: Usuario ----------
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;
}

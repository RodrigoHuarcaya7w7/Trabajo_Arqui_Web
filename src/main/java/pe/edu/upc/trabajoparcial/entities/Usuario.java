package pe.edu.upc.trabajoparcial.entities;

<<<<<<< HEAD


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
=======
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Usuario")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "contrasenia", nullable = false, length = 100)
    private String contrasenia;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private List<Roles> roles;


    public Usuario() {
    }

}
>>>>>>> 71a9f39d081c8bd8f80e51f5bc95c093f0eaff2f

package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
<<<<<<< HEAD
import jakarta.persistence.Entity;
=======
>>>>>>> 71a9f39d081c8bd8f80e51f5bc95c093f0eaff2f
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preguntas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;
    private String pregunta;
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clientes;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
=======
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Pregruntas")
public class Preguntas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
>>>>>>> 71a9f39d081c8bd8f80e51f5bc95c093f0eaff2f
}

package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

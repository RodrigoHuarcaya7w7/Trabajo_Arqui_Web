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
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavorito;
    private String prioridad;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clientes;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
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
public class DireccionEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;
    private String direccion;
    private String referencia;
    private String distrito;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clientes;
}
package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetrica;
    private Integer productosVendidos;
    private Integer productosPublicados;
    private Float ventasTotales;
    private Float calificacionPromedio;
    private LocalDateTime fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clientes;
}

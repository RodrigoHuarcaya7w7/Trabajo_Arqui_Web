package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    private LocalDateTime fecha;
    private Float monto;
    private LocalDateTime fechaPago;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clientes;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago metodoPago;
}
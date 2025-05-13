package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {

    private Integer idPedido;
    private LocalDateTime fecha;
    private Float monto;
    private LocalDateTime fechaPago;
    private Integer idCliente;
    private Integer idMetodoPago;

    // Constructor, getters y setters si es necesario
}
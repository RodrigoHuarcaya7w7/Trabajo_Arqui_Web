package pe.edu.upc.trabajoparcial.DTOs;


import lombok.Data;

@Data
public class DetallePedidoDTO {

    private Integer idDetalle;
    private Integer cantidad;
    private Float precio;
    private Integer idPedido;
    private Integer idProducto;

}
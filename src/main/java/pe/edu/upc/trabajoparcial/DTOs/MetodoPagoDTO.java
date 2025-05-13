package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

@Data
public class MetodoPagoDTO {

    private Integer idMetodoPago;
    private String descripcion;
    private Integer idTipoPago;

}
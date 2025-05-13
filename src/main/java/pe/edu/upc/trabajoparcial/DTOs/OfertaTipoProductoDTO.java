package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OfertaTipoProductoDTO {

    private Integer id;
    private LocalDateTime fechaAplicacion;
    private Integer idProducto;
    private Integer idOferta;

}

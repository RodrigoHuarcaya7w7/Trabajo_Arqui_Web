package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

@Data
public class DireccionEntregaDTO {

    private Integer idDireccion;
    private String direccion;
    private String referencia;
    private String distrito;
    private Integer idCliente;

}
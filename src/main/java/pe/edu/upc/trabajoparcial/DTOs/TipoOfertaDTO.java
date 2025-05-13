package pe.edu.upc.trabajoparcial.DTOs;


import lombok.Data;

@Data
public class TipoOfertaDTO {

    private Integer idTipoOferta;
    private String nombre;
    private String descripcion;
    private Float importe;

}
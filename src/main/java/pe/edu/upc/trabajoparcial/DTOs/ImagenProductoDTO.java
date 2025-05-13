package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

@Data
public class ImagenProductoDTO {

    private Integer idImagenProducto;
    private String urlImagen;
    private String descripcion;
    private Integer idProducto;

}
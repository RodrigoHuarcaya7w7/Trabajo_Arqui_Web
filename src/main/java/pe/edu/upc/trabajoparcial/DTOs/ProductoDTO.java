package pe.edu.upc.trabajoparcial.DTOs;

import lombok.Data;

@Data
public class ProductoDTO {

    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;
    private Integer idCliente;
    private Integer idCategoria;
    private Integer idTipoOferta;

    // Constructor, getters y setters si es necesario
}
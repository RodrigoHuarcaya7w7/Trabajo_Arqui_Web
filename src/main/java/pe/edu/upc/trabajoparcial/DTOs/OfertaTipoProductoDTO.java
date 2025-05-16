package pe.edu.upc.trabajoparcial.DTOs;


import java.time.LocalDateTime;


public class OfertaTipoProductoDTO {

    private Integer id;
    private LocalDateTime fechaAplicacion;
    private Integer idProducto;
    private Integer idOferta;

    public OfertaTipoProductoDTO(Integer id, Integer idOferta, Integer idProducto, LocalDateTime fechaAplicacion) {
        this.id = id;
        this.idOferta = idOferta;
        this.idProducto = idProducto;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public LocalDateTime getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDateTime fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

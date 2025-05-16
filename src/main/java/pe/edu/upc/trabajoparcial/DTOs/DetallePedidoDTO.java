package pe.edu.upc.trabajoparcial.DTOs;



public class DetallePedidoDTO {

    private Integer idDetalle;
    private Integer cantidad;
    private Float precio;
    private Integer idPedido;
    private Integer idProducto;


    public DetallePedidoDTO(Integer idDetalle, Integer idProducto, Integer idPedido, Float precio, Integer cantidad) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
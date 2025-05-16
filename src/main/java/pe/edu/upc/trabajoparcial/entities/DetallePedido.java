package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;


@Entity

public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    private Integer cantidad;
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public DetallePedido() {
    }

    // ✅ Constructor personalizado adicional
    public DetallePedido(Integer idDetalle, Producto producto, Float precio, Integer cantidad, Pedido pedido) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

@Table(name = "Metrica")
public class Metrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetrica;

    private Integer productosVendidos;
    private Float ventasTotales;
    private LocalDateTime fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProducto") // Asegúrate de que este campo esté en Metrica
    private Producto producto;  // Añadir relación con Producto

    public Metrica(){

    }

    public Metrica(Integer idMetrica, Producto producto, Cliente cliente, LocalDateTime fechaActualizacion, Float ventasTotales, Integer productosVendidos) {
        this.idMetrica = idMetrica;
        this.producto = producto;
        this.cliente = cliente;
        this.fechaActualizacion = fechaActualizacion;
        this.ventasTotales = ventasTotales;
        this.productosVendidos = productosVendidos;
    }

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }



    public Float getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(Float ventasTotales) {
        this.ventasTotales = ventasTotales;
    }


    public Integer getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Integer productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
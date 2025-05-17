package pe.edu.upc.trabajoparcial.DTOs;



import java.time.LocalDateTime;


public class MetricaDTO {
    private Integer productoId;
    private String nombreProducto;
    private String categoria;
    private Integer productosVendidos;
    private Double ventasTotales;
    private LocalDateTime fechaUltimaVenta;

    // Constructor
    public MetricaDTO(Integer productoId, String nombreProducto, String categoria,
                      Integer productosVendidos, Double ventasTotales, LocalDateTime fechaUltimaVenta) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.productosVendidos = productosVendidos;
        this.ventasTotales = ventasTotales;
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public LocalDateTime getFechaUltimaVenta() {
        return fechaUltimaVenta;
    }

    public void setFechaUltimaVenta(LocalDateTime fechaUltimaVenta) {
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public Double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(Double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public Integer getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Integer productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
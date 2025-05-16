package pe.edu.upc.trabajoparcial.DTOs;



import java.time.LocalDateTime;


public class MetricaDTO {

    private Integer idMetrica;
    private Integer productosVendidos;
    private Integer productosPublicados;
    private Float ventasTotales;
    private Float calificacionPromedio;
    private LocalDateTime fechaActualizacion;
    private Integer idCliente;

    // Constructor, getters y setters si es necesario


    public MetricaDTO(Integer idMetrica, Integer idCliente, LocalDateTime fechaActualizacion, Float calificacionPromedio, Float ventasTotales, Integer productosVendidos, Integer productosPublicados) {
        this.idMetrica = idMetrica;
        this.idCliente = idCliente;
        this.fechaActualizacion = fechaActualizacion;
        this.calificacionPromedio = calificacionPromedio;
        this.ventasTotales = ventasTotales;
        this.productosVendidos = productosVendidos;
        this.productosPublicados = productosPublicados;
    }

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Float getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Float calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public Float getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(Float ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public Integer getProductosPublicados() {
        return productosPublicados;
    }

    public void setProductosPublicados(Integer productosPublicados) {
        this.productosPublicados = productosPublicados;
    }

    public Integer getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Integer productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
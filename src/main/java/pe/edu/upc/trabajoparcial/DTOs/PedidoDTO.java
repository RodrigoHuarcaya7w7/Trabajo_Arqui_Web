package pe.edu.upc.trabajoparcial.DTOs;



import java.time.LocalDateTime;


public class PedidoDTO {

    private Integer idPedido;
    private LocalDateTime fecha;
    private Float monto;
    private LocalDateTime fechaPago;
    private Integer idCliente;
    private Integer idMetodoPago;

    // Constructor, getters y setters si es necesario


    public PedidoDTO(Integer idPedido, Integer idMetodoPago, LocalDateTime fechaPago, Integer idCliente, Float monto, LocalDateTime fecha) {
        this.idPedido = idPedido;
        this.idMetodoPago = idMetodoPago;
        this.fechaPago = fechaPago;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
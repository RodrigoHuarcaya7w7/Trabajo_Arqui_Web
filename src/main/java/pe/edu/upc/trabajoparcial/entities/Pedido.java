package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Integer idPedido;
    private LocalDateTime fecha;
    private String estado;
    private Float monto;
    private LocalDateTime fechaPago;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago metodoPago;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;
    public Pedido() {
        // 🔧 Requerido por Hibernate
    }

    public Pedido(Integer idPedido, String direccion, MetodoPago metodoPago, Cliente cliente, LocalDateTime fechaPago, Float monto, String estado, LocalDateTime fecha) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
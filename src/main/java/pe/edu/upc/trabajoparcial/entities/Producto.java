package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "precio_descuento", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioDescuento;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_tipo_oferta")
    private TipoOferta tipoOferta;

    public Producto() {
        // Constructor vacío requerido por JPA
    }

    // Constructor opcional con todos los campos
    public Producto(Integer idProducto, TipoOferta tipoOferta, Categoria categoria,
                    Cliente cliente, BigDecimal precio, BigDecimal precioDescuento,
                    Integer stock, String descripcion, String nombre) {
        this.idProducto = idProducto;
        this.tipoOferta = tipoOferta;
        this.categoria = categoria;
        this.cliente = cliente;
        this.precio = precio;
        this.precioDescuento = precioDescuento;
        this.stock = stock;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    @PrePersist
    @PreUpdate
    private void aplicarDescuento() {
        if (precio == null) {
            this.precioDescuento = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
            return;
        }

        if (tipoOferta != null && tipoOferta.getImporte() != null) {
            BigDecimal imp = tipoOferta.getImporte();
            BigDecimal resultado;
            if (imp.compareTo(BigDecimal.ONE) < 0) {
                // Descuento porcentual
                resultado = precio.multiply(BigDecimal.ONE.subtract(imp));
            } else {
                // Descuento de monto fijo
                resultado = precio.subtract(imp).max(BigDecimal.ZERO);
            }
            this.precioDescuento = resultado.setScale(2, RoundingMode.HALF_UP);
        } else {
            // Sin descuento
            this.precioDescuento = precio.setScale(2, RoundingMode.HALF_UP);
        }
    }

    @Transient
    public BigDecimal calcularPrecioConDescuento() {
        if (tipoOferta == null || tipoOferta.getImporte() == null) {
            return precio.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal imp = tipoOferta.getImporte();
        BigDecimal resultado;
        if (imp.compareTo(BigDecimal.ONE) < 0) {
            resultado = precio.multiply(BigDecimal.ONE.subtract(imp));
        } else {
            resultado = precio.subtract(imp).max(BigDecimal.ZERO);
        }
        return resultado.setScale(2, RoundingMode.HALF_UP);
    }

    // Getters y setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(BigDecimal precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoOferta getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(TipoOferta tipoOferta) {
        this.tipoOferta = tipoOferta;
    }
}
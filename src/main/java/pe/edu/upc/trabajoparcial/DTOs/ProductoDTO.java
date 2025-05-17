package pe.edu.upc.trabajoparcial.DTOs;


import java.math.BigDecimal;

public class ProductoDTO {


    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Integer idCliente;
    private Integer idCategoria;
    private Integer idTipoOferta;


    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, Integer idTipoOferta, Integer idCategoria, Integer idCliente, Integer stock, BigDecimal precio, String descripcion) {
        this.nombre = nombre;
        this.idTipoOferta = idTipoOferta;
        this.idCategoria = idCategoria;
        this.idCliente = idCliente;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
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



    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(Integer idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }
}
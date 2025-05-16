package pe.edu.upc.trabajoparcial.DTOs;


public class ProductoDTO {

    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;
    private Integer idCliente;
    private Integer idCategoria;
    private Integer idTipoOferta;

    // Constructor, getters y setters si es necesario


    public ProductoDTO(Integer idProducto, Integer idTipoOferta, Integer idCategoria, Integer stock, Integer idCliente, Float precio, String descripcion, String nombre) {
        this.idProducto = idProducto;
        this.idTipoOferta = idTipoOferta;
        this.idCategoria = idCategoria;
        this.stock = stock;
        this.idCliente = idCliente;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(Integer idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;


@Entity

public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagenProducto;
    private String urlImagen;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public ImagenProducto(){

    }
    public ImagenProducto(Integer idImagenProducto, Producto producto, String descripcion, String urlImagen) {
        this.idImagenProducto = idImagenProducto;
        this.producto = producto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Integer getIdImagenProducto() {
        return idImagenProducto;
    }

    public void setIdImagenProducto(Integer idImagenProducto) {
        this.idImagenProducto = idImagenProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
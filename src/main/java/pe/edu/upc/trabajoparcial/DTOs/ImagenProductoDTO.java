package pe.edu.upc.trabajoparcial.DTOs;


public class ImagenProductoDTO {

    private Integer idImagenProducto;
    private String urlImagen;
    private String descripcion;
    private Integer idProducto;


    public ImagenProductoDTO(Integer idImagenProducto, Integer idProducto, String descripcion, String urlImagen) {
        this.idImagenProducto = idImagenProducto;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Integer getIdImagenProducto() {
        return idImagenProducto;
    }

    public void setIdImagenProducto(Integer idImagenProducto) {
        this.idImagenProducto = idImagenProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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
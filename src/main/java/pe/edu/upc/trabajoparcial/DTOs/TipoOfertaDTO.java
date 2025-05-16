package pe.edu.upc.trabajoparcial.DTOs;



public class TipoOfertaDTO {

    private Integer idTipoOferta;
    private String nombre;
    private String descripcion;
    private Float importe;


    public TipoOfertaDTO(Integer idTipoOferta, Float importe, String descripcion, String nombre) {
        this.idTipoOferta = idTipoOferta;
        this.importe = importe;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(Integer idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
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
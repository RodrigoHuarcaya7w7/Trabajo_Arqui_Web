package pe.edu.upc.trabajoparcial.DTOs;


public class MetodoPagoDTO {

    private Integer idMetodoPago;
    private String descripcion;
    private Integer idTipoPago;


    public MetodoPagoDTO(Integer idMetodoPago, Integer idTipoPago, String descripcion) {
        this.idMetodoPago = idMetodoPago;
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
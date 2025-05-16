package pe.edu.upc.trabajoparcial.DTOs;


public class TipoPagoDTO {

    private Integer idTipoPago;
    private String nombrePago;

    public TipoPagoDTO(Integer idTipoPago, String nombrePago) {
        this.idTipoPago = idTipoPago;
        this.nombrePago = nombrePago;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }
}
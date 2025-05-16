package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;


@Entity


public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;
    private String nombrePago;


    public TipoPago(){

    }
    public TipoPago(Integer idTipoPago, String nombrePago) {
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
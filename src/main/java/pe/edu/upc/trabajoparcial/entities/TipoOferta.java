package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity


public class TipoOferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_oferta")
    private Integer idTipoOferta;
    private String nombre;
    private String descripcion;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal importe;

    public TipoOferta(){

    }

    public TipoOferta(Integer idTipoOferta, BigDecimal importe, String descripcion, String nombre) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre + " (" + importe + ")";
    }


}
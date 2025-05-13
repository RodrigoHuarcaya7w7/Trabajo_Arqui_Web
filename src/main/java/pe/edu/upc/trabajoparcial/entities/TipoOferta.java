package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor

public class TipoOferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoOferta;
    private String nombre;
    private String descripcion;
    private Float importe;

    public TipoOferta(Integer idTipoOferta, String descripcion, String nombre, Float importe) {
        this.idTipoOferta = idTipoOferta;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.importe = importe;
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
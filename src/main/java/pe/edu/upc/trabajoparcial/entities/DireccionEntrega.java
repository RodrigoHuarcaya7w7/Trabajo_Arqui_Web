package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;
    private String direccion;
    private String referencia;
    private String distrito;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public DireccionEntrega(Integer idDireccion, String referencia, String distrito, Cliente cliente, String direccion) {
        this.idDireccion = idDireccion;
        this.referencia = referencia;
        this.distrito = distrito;
        this.cliente = cliente;
        this.direccion = direccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
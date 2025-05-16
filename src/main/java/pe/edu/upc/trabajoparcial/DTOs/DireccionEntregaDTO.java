package pe.edu.upc.trabajoparcial.DTOs;


public class DireccionEntregaDTO {

    private Integer idDireccion;
    private String direccion;
    private String referencia;
    private String distrito;
    private Integer idCliente;


    public DireccionEntregaDTO(Integer idDireccion, Integer idCliente, String distrito, String referencia, String direccion) {
        this.idDireccion = idDireccion;
        this.idCliente = idCliente;
        this.distrito = distrito;
        this.referencia = referencia;
        this.direccion = direccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
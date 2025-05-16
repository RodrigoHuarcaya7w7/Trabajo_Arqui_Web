package pe.edu.upc.trabajoparcial.DTOs;


public class ClienteDTO {

    private Integer idCliente;
    private Integer idUsuario;

    // Constructor, getters y setters si es necesario
    public ClienteDTO() {
    }


    public ClienteDTO(Integer idCliente, Integer idUsuario) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}